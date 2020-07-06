
presentation.pdf: presentation.tex docker logo.png
	cd graphics && make 
	docker run --rm -i --net=none -v "${CURDIR}":/data k8spreso/latex /bin/sh -c "pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex && pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex"

logo.png:
	wget https://solutionstreet.com/img/logo.png

docker:
	docker build -t k8spreso/latex .

clean:
	rm -rf *.aux *.log *.nav *.out *.pdf *.snm *.toc *.vrb *.synctex.gz _minted-presentation logo.png .*.un~
	cd graphics && make clean

