
presentation.pdf: presentation.tex docker-built logo.png graphics/deployToKube.dia graphics/diagram.dia
	cd graphics && make 
	docker run --rm -i --net=none -v "${CURDIR}":/data k8spreso/latex /bin/sh -c "pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex && pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentation.tex"

logo.png:
	wget https://solutionstreet.com/img/logo.png

docker-built:
	docker build -t k8spreso/latex .
	touch docker-built

clean:
	rm -rf *.aux *.log *.nav *.out *.pdf *.snm *.toc *.vrb *.synctex.gz _minted-presentation logo.png .*.un~
	cd graphics && make clean

