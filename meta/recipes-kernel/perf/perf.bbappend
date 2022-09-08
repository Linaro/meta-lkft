# As of linux-next-20191022, we need bpf_helpers_doc.py in order to
# build libbpf, which lives in /scripts. See commit e01a75c159691
# ("libbpf: Move bpf_{helpers, helper_defs, endian, tracing}.h into
# libbpf").
PERF_SRC += "scripts"

DEPENDS += "python3 python3-setuptools-native"
RDEPENDS:${PN} += "libcap"
RDEPENDS:${PN}-python += "libcap"
RDEPENDS:${PN}-tests += "bash"

PACKAGECONFIG[coresight] = "CORESIGHT=1,,opencsd"

PACKAGECONFIG:append = " coresight"

export HOSTCFLAGS = "${BUILD_CFLAGS}"
export HOSTCXXFLAGS = "${BUILD_CXXFLAGS}"
export HOSTLDFLAGS = "${BUILD_LDFLAGS}"
