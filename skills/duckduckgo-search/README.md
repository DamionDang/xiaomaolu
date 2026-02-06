# DuckDuckGo Search Skill

A Clawdbot skill that enables web search functionality using DuckDuckGo's Instant Answer API.

## Overview

This skill allows Clawdbot to perform web searches and return relevant results from DuckDuckGo. It uses the official DuckDuckGo API to fetch search results without requiring an API key.

## Features

- Web search using DuckDuckGo's Instant Answer API
- Formatted output with headings, summaries, and related results
- No API key required
- Clean, readable markdown output

## Requirements

- Node.js
- `curl` command-line utility
- Internet connection

## Usage

To use this skill, simply invoke it when you need to search the web:

```
node search.js "your search query here"
```

## Example

```
node search.js "JavaScript tutorial"
```

This will return formatted search results from DuckDuckGo related to JavaScript tutorials.

## Integration with Clawdbot

This skill can be integrated into Clawdbot workflows to provide web search capabilities when users request information that requires current web data.