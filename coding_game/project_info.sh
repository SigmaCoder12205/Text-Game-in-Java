#!/usr/bin/env bash
set -euo pipefail

ROOT="${1:-.}"

count_files() {
  find "$ROOT" -type f | wc -l | awk '{print $1}'
}

count_dirs() {
  find "$ROOT" -type d | wc -l | awk '{print $1}'
}

count_java_files() {
  find "$ROOT/src" -type f -name "*.java" 2>/dev/null | wc -l | awk '{print $1}'
}

count_test_files() {
  find "$ROOT/src/test" -type f 2>/dev/null | wc -l | awk '{print $1}'
}

count_main_files() {
  find "$ROOT/src/main" -type f 2>/dev/null | wc -l | awk '{print $1}'
}

loc_java() {
  find "$ROOT/src" -type f -name "*.java" 2>/dev/null -print0 \
    | xargs -0 wc -l 2>/dev/null \
    | tail -n 1 \
    | awk '{print $1}'
}

pom_value() {
  local tag="$1"
  grep -m1 -oP "(?<=<$tag>).*?(?=</$tag>)" "$ROOT/pom.xml" 2>/dev/null || echo "N/A"
}

top_level_tree() {
  find "$ROOT" -maxdepth 4 \
    \( -path "$ROOT/target" -o -path "$ROOT/target/*" \) -prune -o \
    -print | sed "s|^\Q$ROOT\E|.|" | sort
}

echo "CODEBASE REPORT"
echo "================"
echo "Root: $ROOT"
echo

echo "Maven"
echo "-----"
echo "groupId:    $(pom_value groupId)"
echo "artifactId: $(pom_value artifactId)"
echo "version:    $(pom_value version)"
echo "packaging:  $(pom_value packaging)"
echo

echo "Stats"
echo "-----"
echo "Directories:      $(count_dirs)"
echo "Files:            $(count_files)"
echo "Java source files: $(count_java_files)"
echo "Main files:       $(count_main_files)"
echo "Test files:       $(count_test_files)"
echo "Java LOC:         $(loc_java)"
echo

echo "Source files"
echo "------------"
find "$ROOT/src/main/java" -type f -name "*.java" 2>/dev/null | sort | sed "s|^\Q$ROOT\E/||"
echo

echo "Test files"
echo "----------"
find "$ROOT/src/test/java" -type f -name "*.java" 2>/dev/null | sort | sed "s|^\Q$ROOT\E/||"
echo

echo "Project tree"
echo "------------"
top_level_tree
A
