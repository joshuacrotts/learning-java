cd .. \
&& rm -rf new-java \
&& mkdir new-java \
&& cd new-java \
&& git clone git@github.com:joshuacrotts/teaching-java.git \
&& cd .. \
&& cd teaching-java \
&& rm -rf *.git \
&& cp -r ../new-java/teaching-java/.git . \
&& rm -rf ../new-java/
