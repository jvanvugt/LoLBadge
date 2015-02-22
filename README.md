# LoLBadge
Badge creator for 2015 CognAC League of Legends Tournament.

## Summary
A .csv file with summonernames, rank and teamnames is converted to a badge per participant.
The badges are then included in a .tex file which is compiled with pdflatex.

## Notes
The image locations and data location are hardcoded.
The input data must be a .csv file without byte order mark. 
pdflatex must be in your path.
Handling for weird names is added where necessary
