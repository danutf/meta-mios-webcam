do_install_append () {
	echo "V1:5:respawn:/usr/bin/miosgrab -o /run" >> ${D}${sysconfdir}/inittab
}
