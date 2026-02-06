#!/usr/bin/env node

// DuckDuckGo Search Skill for Clawdbot
const { spawnSync } = require('child_process');

/**
 * Perform a DuckDuckGo search using the Instant Answer API via curl
 * @param {string} query - The search query
 * @returns {Object} - Search results
 */
function duckduckgoSearch(query) {
  const encodedQuery = encodeURIComponent(query);
  const url = `https://api.duckduckgo.com/?q=${encodedQuery}&format=json&no_html=1&skip_disambig=1`;
  
  const result = spawnSync('curl', ['-s', url], { encoding: 'utf8' });
  
  if (result.status !== 0) {
    throw new Error(`curl command failed with status: ${result.status}`);
  }
  
  return JSON.parse(result.stdout);
}

/**
 * Format search results for display
 * @param {Object} results - DuckDuckGo API results
 * @returns {string} - Formatted results
 */
function formatResults(results) {
  let output = `# DuckDuckGo Search Results for: ${results.Heading || 'Unknown'}\n\n`;
  
  // Add heading if available
  if (results.Heading && results.Heading.length > 0) {
    output += `## ${results.Heading}\n`;
  }
  
  // Add abstract if available
  if (results.Abstract && results.Abstract.length > 0) {
    output += `${results.Abstract}\n\n`;
  } else if (results.AbstractText && results.AbstractText.length > 0) {
    output += `${results.AbstractText}\n\n`;
  }
  
  // Add AbstractURL if available
  if (results.AbstractURL && results.AbstractURL.length > 0) {
    output += `[More information](${results.AbstractURL})\n\n`;
  }
  
  // Add related topics if available
  if (results.RelatedTopics && results.RelatedTopics.length > 0) {
    output += "## Related Results:\n";
    const topics = results.RelatedTopics.slice(0, 5); // Limit to first 5 results
    
    for (const topic of topics) {
      if (topic.FirstURL) {
        // Extract text properly
        let displayText = topic.Text || topic.Name || topic.Result;
        if (displayText && displayText.includes('<a')) {
          // Simple HTML tag removal
          displayText = displayText.replace(/<[^>]*>/g, '');
        }
        output += `- [${displayText}](${topic.FirstURL})\n`;
      }
    }
    
    output += "\n";
  }
  
  // Add results if available
  if (results.Results && results.Results.length > 0) {
    output += "## Additional Results:\n";
    const resultsList = results.Results.slice(0, 3); // Limit to first 3 results
    
    for (const result of resultsList) {
      if (result.FirstURL) {
        let displayText = result.Text || result.Result;
        if (displayText && displayText.includes('<a')) {
          // Simple HTML tag removal
          displayText = displayText.replace(/<[^>]*>/g, '');
        }
        output += `- [${displayText}](${result.FirstURL})\n`;
      }
    }
  }
  
  if (!results.Abstract && !results.AbstractText && 
      (!results.RelatedTopics || results.RelatedTopics.length === 0) && 
      (!results.Results || results.Results.length === 0)) {
    output = "No results found for the given query.";
  }
  
  return output;
}

// Main execution
function main() {
  const args = process.argv.slice(2);
  const query = args.join(' ');
  
  if (!query) {
    console.error("Usage: node search.js <search query>");
    process.exit(1);
  }
  
  try {
    const results = duckduckgoSearch(query);
    const formattedOutput = formatResults(results);
    console.log(formattedOutput);
  } catch (error) {
    console.error(`Error performing search: ${error.message}`);
    process.exit(1);
  }
}

if (require.main === module) {
  main();
}

module.exports = { duckduckgoSearch, formatResults };