
DESCRIPTION = "QML TaskWarrior Executioner"
HOMEPAGE = "https://www.frozentux.net"
LICENSE = "MPL-2.0"
DEPENDS += "qtbase"

RDEPENDS_${PN} += "qtdeclarative"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9741c346eef56131163e13b9db1241b3"

PR = "r1"

inherit cmake_qt5

SRC_URI = " \
    git://github.com/frznlogic/qml-taskwarrior-executioner.git \
"

SRCREV = "1fd1647eaf573a3f54eb8621587fc1a3d39b3eca"
PV = "0.1+git${SRCREV}"

S = "${WORKDIR}/git"

FILES_${PN} += " \
    /usr/lib/qt5/qml/net/frozentux/qmlcomponents/libqml-taskwarrior-executioner.so \
    /usr/lib/qt5/qml/net/frozentux/qmlcomponents/qmldir \
"

FILES_${PN}-dbg += " \
    /usr/lib/qt5/qml/net/frozentux/qmlcomponents/.debug/* \
"

