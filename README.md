# LoLBadge
Badge creator for 2015 CognAC League of Legends Tournament.

## Summary
A .csv file with summonernames, rank and teamnames is converted to a badge per participant.
The badges are then included in a .tex file which is compiled with pdflatex.

## Usage
1. Make sure pdflatex is in your path (for instance by installing MiKTeX)
2. Install the [Friz Quadrata font](http://fontsgeek.com/fonts/Friz-Quadrata-Std-Medium).
2. Put a file called `badge_list.csv` in the `res` folder. The format of the csv is `Summoner Name,Silver,3,Team Name`.
3. Run `BadgeCreator.java`
4. The `pdf` folder will now contain a file called `badges.pdf`

## Notes
The image locations and data location are hardcoded.
The input data must be a .csv file without byte order mark. 
pdflatex must be in your path.
Handling for weird names is added where necessary
