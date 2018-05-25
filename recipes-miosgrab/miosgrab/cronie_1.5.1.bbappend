do_install_append () {
	echo "* * * * *		root	/usr/bin/purge.sh > /dev/null" >> ${D}${sysconfdir}/crontab
	echo "0 1 * * * 	root	/usr/bin/img_cleanup.sh > /dev/null" >> ${D}${sysconfdir}/crontab	
}
