
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM anapsix/alpine-java
copy dist/qldvxp.jar
copy dist/lib
CMD ["java","-jar","qldvxp.jar"]
