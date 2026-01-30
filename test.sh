#!/bin/bash
echo "Testing Enhanced Calculator..."
echo "=============================="

echo "Test 1: Addition"
java EnhancedCalculator 10 + 5

echo -e "\nTest 2: Modulo"
java EnhancedCalculator 15 % 4

echo -e "\nTest 3: Power"
java EnhancedCalculator 2 ^ 8

echo -e "\nTest 4: Square Root"
java EnhancedCalculator sqrt 25

echo -e "\nTest 5: Precision Control"
java EnhancedCalculator --precision 5 22 / 7

echo -e "\nTest 6: Help"
java EnhancedCalculator --help | head -10

echo -e "\nAll tests completed!"
