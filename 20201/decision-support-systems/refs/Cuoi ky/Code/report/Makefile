.PHONY: all
all: report.pdf

report.pdf: report.bbl 	\
			report.tex 	\
			sections/title-page.tex \
			sections/introduction.tex \
			sections/basic.tex \
			sections/algorithm.tex \
			sections/implementation.tex \
			sections/conclusion.tex
	pdflatex report.tex

report.bbl: report.bib 
	pdflatex report.tex
	bibtex report
	pdflatex report.tex
