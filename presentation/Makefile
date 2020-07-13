
presentation: presentation.pdf handout.pdf

presentation.pdf: presentationSlideshow.tex presentation.tex docker-built logo.png graphics/deployToKube.dia graphics/diagram.dia graphics/simplifiedModel.dia
	cd graphics && make 
	docker run --rm -i --net=none -v "${CURDIR}":/data k8spreso/latex /bin/sh -c "pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentationSlideshow.tex && pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentationSlideshow.tex"

handout.pdf: presentationHandout.tex presentation.tex docker-built logo.png graphics/deployToKube.dia graphics/diagram.dia graphics/simplifiedModel.dia
	cd graphics && make
	docker run --rm -i --net=none -v "${CURDIR}":/data k8spreso/latex /bin/sh -c "pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentationHandout.tex && pdflatex -synctex=1 -interaction=nonstopmode -shell-escape presentationHandout.tex"

logo.png:
	wget https://solutionstreet.com/img/logo.png

docker-built: Dockerfile
	docker build -t k8spreso/latex .
	touch docker-built

clean:
	rm -rf *.aux *.log *.nav *.out *.pdf *.snm *.toc *.vrb *.synctex.gz _minted-presentation logo.png .*.un~ docker-built
	cd graphics && make clean

