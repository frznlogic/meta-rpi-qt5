
DESCRIPTION = "QmlMirror"
HOMEPAGE = "https://www.frozentux.net"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=9741c346eef56131163e13b9db1241b3 \
"
DEPENDS += "qtbase qtdeclarative qtquick1 qtmultimedia qtscript"

PR = "r1"

inherit cmake_qt6 systemd

SRC_URI += " \
    git://github.com/frznlogic/qmlmirror.git \
"

SRCREV = "4b153fef10901b0f6aead41d96bcee9a01ea3b23"

S = "${WORKDIR}/git/"

RDEPENDS_${PN} = " \
    qtbase \
    qtbase-plugins \
    qtdeclarative-qmlplugins \
    qtdeclarative \
    qtdeclarative-tools \
    qml-taskwarrior-executioner \
"

do_install_append() {
    install -Dm0644 ${S}/yocto/qmlmirror.service ${D}/${base_libdir}/systemd/system/qmlmirror.service
    mkdir -p ${D}/${datadir}/qmlmirror/
    install -Dm0755 ${S}/yocto/launch.sh ${D}/${datadir}/qmlmirror/
}

FILES_${PN} += "${libdir}/qt5/qml \
                ${datadir} \
"

FILES_${PN}-dbg += " \
    ${libdir}/qt5/qml/net/frozentux/weatherinfo/.debug \
"

SYSTEMD_SERVICE_${PN} = "qmlmirror.service"


