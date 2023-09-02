/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.utils;

import java.io.*;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * PoiUtils POI相关操作
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/20
 */
public class PoiUtils {

    /**
     * createExcelFile 生成Excel文件
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/20
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
