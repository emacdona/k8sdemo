
presentation.pdf: presentation.tex
	cd graphics && make 
	pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex
	pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex

clean:
	rm -rf *.aux *.log *.nav *.out *.pdf *.snm *.toc *.vrb *.synctex.gz _minted-presentation
	cd graphics && make clean
