SUMMARY = "Organize packages to avoid duplication across all images"

inherit packagegroup

SUMMARY:packagegroup-lkft-testsuites = "Test suites used by LKFT"
RDEPENDS:packagegroup-lkft-testsuites = "\
    ${@bb.utils.contains_any("TUNE_ARCH", "arm", "", "fwts", d)} \
    ${@bb.utils.contains("TUNE_ARCH", "mips", "", "\
      igt-gpu-tools \
      igt-gpu-tools-benchmarks \
      igt-gpu-tools-tests \
    ", d)} \
    kernel-selftests \
    libgpiod \
    libgpiod-tools \
    ltp \
    s-suite \
    vdsotest \
    "
