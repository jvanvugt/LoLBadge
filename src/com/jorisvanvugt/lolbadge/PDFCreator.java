package com.jorisvanvugt.lolbadge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PDFCreator {
	public void createPDF(ArrayList<Participant> participants){
		try {
			StringBuilder texSource = new StringBuilder();
			texSource.append("\\documentclass{article}" 			+ "\n" +
						 "\\author{}" 							+ "\n" +
 						 "\\date{}" 							+ "\n" +
 						 "\\title{}" 							+ "\n" +
						 "\\usepackage{graphicx}" 				+ "\n" +
						 "\\usepackage{fullpage}" 				+ "\n" +
						 "\\usepackage{subfigure}" 				+ "\n" +
						 "\\usepackage[export]{adjustbox}" 		+ "\n" +
						 "\\usepackage[margin=0.5cm]{geometry}" + "\n" +
						 "\\begin{document}"					+ "\n" +
						 "\\begin{figure}[ht]"					+ "\n" 
					);
			
			for(int i = 0; i < participants.size(); i++){
				texSource.append("\\subfigure{\\includegraphics[width=95mm, frame]{../badges/" + participants.get(i).getFileName() + "}}");
				if(i != 0 && i % 5 == 0){
					texSource.append("\n\\end{figure}\n" +
								 "\\clearpage\n" +
								 "\\begin{figure}[ht]\n"
								 );
				} else if(i % 2 == 1){
					texSource.append(" \\\\");
				} 
				if(i == participants.size() - 1) {
					texSource.append("\n\\end{figure}\n");
				}
				texSource.append("\n");
			}
			
			texSource.append("\\end{document}\n");
			PrintWriter writer = new PrintWriter(new File("pdf\\badges.tex"));
			writer.write(texSource.toString());
			writer.close();
			
			System.out.println(new CMDCommand("cd pdf && pdflatex badges.tex").run());
		} catch (FileNotFoundException e) {
			System.err.println("Make sure you run BadgeCreator with the same participants before running PDFCreator");
			e.printStackTrace();
		}
	}
	
}
