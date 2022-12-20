# Simple-parser

**parser** is a program that's usually part of a compiler. It receives input in the form of sequential source program instructions, interactive online commands, markup tags or some other defined interface.<br>
The type of this parser is ***Recursive descent parser***. Recursive descent parsers backtrack after each decision point to double-check accuracy. Recursive descent parsers use top-down parsing.<br>

## Overview
In this project, we built a parser for Arithmetic grammer that is able to preforme the basic arithmetic operations : `SUM`, `SUBTRACT`, `MULTIPLAY` and `DIVISION`.
## Phases
**1. Get Lexems.<br>**
`ArithmeticScan` class contains `StreamTokenizer` class That reads a file and extract the tokens from the input. those tokens are the input of the next stage.<br>
**2. Parse and Evaluation.<br>**
`ArithmeticEvaluationAndParser` class contains the implementation of the given grammer in `"Grammer.txt"` file. In this class, we will use the tokens from the previous stage and evaluate the result.
<hr>

**`Note`** I built a lexical-Analyzer, you can check from [here](https://github.com/mohamed0tarek/Lexical-Analyzer).
