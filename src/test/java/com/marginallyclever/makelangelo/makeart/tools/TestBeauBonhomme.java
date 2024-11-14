package com.marginallyclever.makelangelo.makeart.tools;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TestBeauBonhomme {
    @Test
    public void TestIsBeauBonhomme() throws IOException {
        final String PATH_NAME = "src/test/resources/Emeric-Beau-Bonhomme";
        final String EXT = "jpg";
        File file = new File(PATH_NAME + "." + EXT);
        assertTrue(IsBeauBonhomme(file));
    }

    private static boolean IsBeauBonhomme(File file) {
        return file.exists() && file.getName().contains("Emeric");
    }
}
