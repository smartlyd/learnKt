package com.example.liyueda.learnjvm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.example.liyueda.learnjvm
 * @description: TODO
 * @date: 2020-02-24
 * @time: 11:36
 */
public class TestEndian {


    public static void main(String[] args) {

        byte[] content = new byte[]{0x01, 0x02, 0x03, 0x04};
        int littleEndian = (0x04 << 24) | (0x03 << 16) | (0x02 << 8) | (0x01 << 0);
        int bigEndian = (0x01 << 24) | (0x02 << 16) | (0x03 << 8) | (0x04 << 0);

        ByteBuffer byteBuffer = ByteBuffer.wrap(content);
        int readValue = byteBuffer.getInt();
        System.out.println(readValue);
        System.out.println(bigEndian);
        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        readValue = byteBuffer.getInt();
        System.out.println(readValue);
        System.out.println(littleEndian);

    }

    public class ELF64FileHeader{
        final static int ET_NIDENT = 16;
        byte[] e_ident = new byte[ET_NIDENT];
        ELF64_Half e_type;
        ELF64_Half e_machine;
        ELF64_Word e_version;
        ELF64_Addr e_entry;
        ELF64_Off e_phoff;
        ELF64_Off e_shoff;
        ELF64_Word e_flags;
        ELF64_Half e_ensize;
        ELF64_Half e_phentsize;
        ELF64_Half e_phnums;
        ELF64_Half e_shentsize;
        ELF64_Half e_shnum;
        ELF64_Half e_shstrndx;

    }

    public class ELF32FileHeader{
        final static int ET_NIDENT = 16;
        byte[] e_ident = new byte[ET_NIDENT];
        ELF32_Half e_type;
        ELF32_Half e_machine;
        ELF32_Word e_version;
        ELF32_Addr e_entry;
        ELF32_Off e_phoff;
        ELF32_Off e_shoff;
        ELF32_Word e_flags;
        ELF32_Half e_ensize;
        ELF32_Half e_phentsize;
        ELF32_Half e_phnums;
        ELF32_Half e_shentsize;
        ELF32_Half e_shnum;
        ELF32_Half e_shstrndx;
    }

    class ELF64_Half {
    }
    class ELF64_Word {
    }
    class ELF64_Addr {
    }
    class ELF64_Off{
    }


    class ELF32_Half {
    }
    class ELF32_Word {
    }
    class ELF32_Addr {
    }
    class ELF32_Off{
    }


}
