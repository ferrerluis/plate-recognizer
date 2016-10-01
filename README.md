# PlateRecognizer for Java

## Usage

- Import PlateRecognizer: `import com.ragerant.PlateRecognizer`.
- Use static function `recognize` by passing in image File object.
- It will return a String representing the license plate.

e.g.
```java
  import com.ragerant.PlateRecognizer

  public static main(String[] args) {
    File img = new File("path/to/file");
    licPlate = PlateRecognizer.recognize(img);
  }
```

EZ
