cd .. \
&& rm -rf new-java \
&& mkdir new-java \
&& cd new-java \
&& git clone git@github.com:joshuacrotts/learning-java.git \
&& cd learning-java \
&& git checkout springer \
&& cd .. \
&& cd .. \
&& cd learning-java \
&& rm -rf *.git \
&& sudo cp -r ../new-java/learning-java/.git . \
&& rm -rf ../new-java/
