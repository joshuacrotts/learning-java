cd .. \
&& rm -rf new-java \
&& mkdir new-java \
&& cd new-java \
&& git clone git@github.com:joshuacrotts/testing-java.git \
&& cd .. \
&& cd testing-java \
&& rm -rf *.git \
&& cp -r ../new-java/testing-java/.git . \
&& rm -rf ../new-java/
