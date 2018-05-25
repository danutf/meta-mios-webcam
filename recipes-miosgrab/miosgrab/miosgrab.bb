SUMMARY = "MiOS grab utility"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d749e86a105281d7a44c2328acebc4b0"

RDEPENDS_${PN} += "v4l-utils"

SRC_URI = "git://github.com/danutf/miosgrab.git"
SRCREV="29c8ac309c46ac538022a362b989024eb98b57e4"

S = "${WORKDIR}"
EXTRA_OEMAKE = "-e MAKEFLAGS="
CFLAGS += "-I${S}/include"

FILES_${PN} += "${bindir}"

do_install (){
	pwd
	ls -l 
	install -d ${D}${bindir}
	install -m 0755 ./miosgrab ${D}${bindir}
	install -m 0755 ${WORKDIR}/git/scripts/purge.sh ${D}${bindir}
	install -m 0755 ${WORKDIR}/git/scripts/img_cleanup.sh ${D}${bindir}
}
