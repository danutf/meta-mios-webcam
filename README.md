# meta-mios-webcam
Please check 'other' directory to review:
- build/conf/bblayer.conf
  Add new BBLAYERS:
> 	/home/danutf/poky/meta-openembedded/meta-oe \
>  	/home/danutf/poky/meta-mios-webcam \
 
- build/conf/local.conf
  Changes:
> 	MACHINE ??= "qemux86"
> 	IMAGE_INSTALL_append = " cronie helloworld v4l-utils miosgrab"
> 	CORE_IMAGE_EXTRA_INSTALL += "v4l2loopback-mod"


#meta-openembedded required changes
Also you may find there a git diff output on the meta-openembedded layer as my yocto version was 2.4.2 (rocko) and the layer was already written for 2.5 (sumo).
Basically besides sumo->rocko changes the patch should remove packages depending on pypi.
How to apply differences:
```
cd ~/poky
git clone https://github.com/openembedded/meta-openembedded.git
cd meta-openembedded
git checkout a19aa29f7fa336cd075b72c496fe1102e6e5422b
git apply ../meta-mios-webcam/other/git-diff-meta-openembedded.patch
```
