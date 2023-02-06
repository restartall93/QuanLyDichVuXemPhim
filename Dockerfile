
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM anapsix/alpine-java

# copy jar to docker file
copy dist/QLDVXP.jar .

CMD ["java", "-jar", "QLDVXP.jar"]
