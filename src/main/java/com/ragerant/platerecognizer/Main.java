package com.ragerant.platerecognizer;

import java.io.File;

class Main {
    public static void main(String[] args) {
        String imgPath = "src/main/res/com/ragerant/platerecognizer/1.jpg";

        File img = new File(imgPath);
        System.out.println(PlateRecognizer.recognize(img));
    }
}