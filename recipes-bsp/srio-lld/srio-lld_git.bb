DESCRIPTION = "TI SRIO peripheral low level driver"
COMPATIBLE_MACHINE = "keystone"

DEPENDS="common-csl-ip rm-lld cppi-lld"

include srio-lld.inc

do_compile () {
#   Now build the lld
	oe_runmake clean
	for device in ${DEVICELIST}
	do
		oe_runmake lib DEVICE="${device}"
	done
}

do_install () {
	oe_runmake install INSTALL_INC_BASE_DIR=${D}${includedir} INSTALL_LIB_BASE_DIR=${D}${libdir}
}
