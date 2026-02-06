---
name: duckduckgo_search
description: A skill that enables web search functionality using DuckDuckGo's Instant Answer API.
---

# DuckDuckGo Search Skill

This skill provides web search functionality using DuckDuckGo.

## Description
A skill that enables Clawdbot to perform web searches using DuckDuckGo as the search engine. This skill uses the DuckDuckGo Instant Answer API to retrieve search results.

## Usage
When a user requests information that requires web search, this skill will be invoked to search DuckDuckGo and return relevant results. To perform a search, use the `exec` tool to run the search script:

```bash
node /Users/dangruizhi/clawd/skills/duckduckgo-search/search.js "your search query"
```

## Dependencies
- `curl` command-line utility
- Internet connection
- Node.js

## Implementation
This skill uses DuckDuckGo's Instant Answer API to perform searches.