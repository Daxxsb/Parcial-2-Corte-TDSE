package com.parcialtdse;

public record SearchResult(
    String operation,
    String inputlist,
    String value,
    String output
) {}