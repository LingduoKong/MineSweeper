# Readme

Thanks for your interest in the Tophatter code challenge. This challenge is designed to be a fun way for you to show us how you think about and write code.

### What will you be building?

We're going to implement Minesweeper. Please familiarize yourself with the rules and gameplay [here](https://en.wikipedia.org/wiki/Microsoft_Minesweeper). Try playing the game [here](http://minesweeperonline.com/).

There are two parameters that you should ask from the user when you setup a Minesweeper board:

- The size of the grid to use (NxN square grid).
- The number of mines to be placed.

Some considerations to keep in mind when you're building:

- The game is lost when the user clicks on a cell the contains a mine.
- The game is won when all the uncovered cells are cells containing mines.
- The mines should be randomly placed on the grid.
- You don't need to build support for flagging cells. The game should end when all uncovered cells are cells containing mines.

# Choosing how to build your Minesweeper

There are two ways to solve this challenge depending on what your strongest language is.

- **If your strongest language is JavaScript** please proceed to **Challenge A**.

- **If your strongest language is not JavaScript** please proceed to **Challenge B**.

For both challenges, you'll be building a solver which is described below.


# Challenge A: JavaScript

Implement Minesweeper using JavaScript. Using other libraries such as jQuery is allowed. Your challenge should use the images provided for the various states of the cells.

**Please start from this JS Bin URL: [http://jsbin.com/bibiwad/edit?html,js,output](http://jsbin.com/bibiwad/edit?html,js,output)**

Once you've completed implementing Minesweeper, proceed to building a solver (see below).

# Challenge B: Ruby, Python, or Java

Implement Minesweeper using Ruby, Python, or Java. Your Minesweeper application should run in a terminal and accept user input.

Represent the various states of the cells in the following way:

- A covered, untouched cell should be an X or this unicode character: ◼.
- An uncovered, empty cell should be a period.
- A cell with a mine should be an 'M'.

Once you've completed implementing Minesweeper, proceed to building a solver (see below).

# Building a solver

Once your Minesweeper implementation is complete, write a solver. The solver should attempt to solve your Minesweeper puzzles 1,000 times with the following parameters:

- The size of the board should be 10x10.
- The number of mines should be 10.

The output should be:

- The number of puzzles successfully solved out of 1,000 attempts.
- The total time to complete the 1,000 attempts.

Please submit your challenge as a packaged ZIP file, a Dropbox link, or a Github repository. It should work in the latest version of the major browsers (Chrome, Firefox, Safari, IE).

# What we're looking for

We look for the following:

- Code quality: is your code readable? Is it maintainable? Is it object oriented? Does it follow conventions such as Don't Repeat Yourself?
- Completion: Did you complete the challenge? Your game should be playable and not have any missing functionality.
- Optimization: Were you able to achieve a strong completion rate in your solver?
- Ruby is strongly preferred, but we will consider good submissions in any language.
- Test coverage: this is optional, but encouraged.
- Ease of use: Was it clear how to run your submission?

If we like your submission, the technical portion of interviewing is finished and we'll invite you on-site to meet with various members of the engineering team.

# Questions

If you have any questions please don't hesitate to contact [jared@tophatter.com](mailto:jared@tophatter.com).
