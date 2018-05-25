do_install_append () {
	echo "V0:5:respawn:/usr/bin/ondemandcam /dev/video0 > /dev/null" >> ${D}${sysconfdir}/inittab
}
