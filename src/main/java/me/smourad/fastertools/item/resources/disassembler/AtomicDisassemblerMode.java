package me.smourad.fastertools.item.resources.disassembler;

public enum AtomicDisassemblerMode {

    SLOW, NORMAL, FAST, OFF;

    public static AtomicDisassemblerMode[] getMiningMode() {
        return new AtomicDisassemblerMode[] {
                AtomicDisassemblerMode.SLOW,
                AtomicDisassemblerMode.NORMAL,
                AtomicDisassemblerMode.FAST
        };
    }
}
