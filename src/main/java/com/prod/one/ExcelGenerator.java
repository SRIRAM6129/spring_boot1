    package com.prod.one;

    import org.apache.poi.ss.usermodel.Cell;
    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
    import org.springframework.stereotype.Component;
    import java.io.ByteArrayOutputStream;
    import java.io.IOException;
    import java.util.List;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    @Component
    public class ExcelGenerator {

        public byte[] createExcelOnProductByCustomerId(List<ProductModel> products) throws IOException {

            try(Workbook workbook = new XSSFWorkbook()){
                Sheet sheet = workbook.createSheet();

                Row row = sheet.createRow(0);
                String[] columns = {"CUSTOMER ID", "CUSTOMER NAME","DATE","TIME","QUANTITY"};
                for(int i = 0; i < columns.length; i++){
                    Cell cell = row.createCell(i);
                    cell.setCellValue(columns[i]);
                }

                int rowindex = 1;
                for (ProductModel product : products) {
                    row = sheet.createRow(rowindex);
                    row.createCell(0).setCellValue(product.getCustomerId());
                    row.createCell(1).setCellValue(product.getClient().getName());
                    row.createCell(2).setCellValue(product.getCreatedDate().toString());
                    row.createCell(3).setCellValue(product.getCreatedTime().toString());
                    row.createCell(4).setCellValue(product.getQuantity());
                }

                for (int i = 0;i<columns.length;i++){
                    sheet.autoSizeColumn(i);
                }

                try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
                    workbook.write(out);
                    return out.toByteArray();
                }
            }
        }
    }
