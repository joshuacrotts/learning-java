.PHONY: java clean cleanpdf

OUTPUT = main.pdf
TIMESTAMP = $(shell date +%Y%m%d_%H%M%S)

java: $(OUTPUT)

$(OUTPUT):
	latexmk -halt-on-error -pdf -shell-escape -jobname=java main && pdftk java.pdf cat 3-end output java-book.pdf


clean:
	latexmk -C
	rm -rf _minted-*
	find . -type f -name "*.aux" -delete
	find . -type f -name "*.log" -delete
	find . -type f -name "*.toc" -delete
	find . -type f -name "*.out" -not -path "./code/*" -not -path "./res/*"
	find . -type f -name "*.nav" -delete
	find . -type f -name "*.snm" -delete
	find . -type f -name "*.vrb" -delete
	find . -type f -name "*.bbl" -delete
	find . -type f -name "*.blg" -delete
	find . -type f -name "*.bcf" -delete
	find . -type f -name "*.idx" -delete
	find . -type f -name "*.ilg" -delete
	find . -type f -name "*.ind" -delete
	find . -type f -name "*.lof" -delete
	find . -type f -name "*.run.xml" -delete
	find . -type f -name "*.fls" -delete
	find . -type f -name "*.fdb_latexmk" -delete

cleanpdf:
	find . -type f -name "*.pdf" -delete
