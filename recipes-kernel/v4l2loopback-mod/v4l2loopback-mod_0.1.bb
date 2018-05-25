SUMMARY = "Example of how to build an external Linux kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRC_URI = "file://v4l2loopback.tgz \
          "

S = "${WORKDIR}"

TARGET_CC_ARCH +="${LDFLAGS}"

LDFLAGS_append += " -pthread"
KERNEL_MODULE_AUTOLOAD += " v4l2loopback"

#
do_compile_append () {
	cd ./examples
	${CC} ondemandcam.c -o ondemandcam -lrt -lpthread
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
FILES_${PN} += "${bindir}/ondemandcam ${bindir}/no_image.png ${bindir}/v4l2loopback-ctl"
do_install_append (){
	pwd
	ls -l ./examples
	ls -l ./utils
	install -d ${D}${bindir}
	install -m 0755 ./examples/ondemandcam ${D}${bindir}
	install -m 0755 ./utils/no_image.png ${D}${bindir}
	install -m 0755 ./utils/v4l2loopback-ctl ${D}${bindir}
}
