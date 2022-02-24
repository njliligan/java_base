package com.njganlili.juc.callback.tea.futrue.future.demo;

/**
 * @author njgan
 * @description
 * @date 2022/2/18 16:16
 */
public class CompletableFutrueExample {
//
//    public CustomResponse process() {
//        CustomResponse msgResponse = new CustomResponse();
//        try {
//            // 1. DbCall 1
//            CompletableFuture<Void> f1 = dataHelper.fetchAndUploadCSV1();
//            // 2. DbCall 2
//            CompletableFuture<Void> f2 = dataHelper.fetchAndUploadCSV2();
//            // 3. DbCall 3
//            CompletableFuture<Void> f3 = dataHelper.fetchAndUploadCSV3();
//            // 4. DbCall 4
//            CompletableFuture<Void> f4 = dataHelper.fetchAndUploadCSV4();
//            // 5. DbCall 5
//            CompletableFuture<Void> f5 = dataHelper.fetchAndUploadCSV5();
//            // 6. DbCall 6
//            CompletableFuture<Void> f6 = dataHelper.fetchAndUploadCSV6();
//            // 7. DbCall 7
//            CompletableFuture<Void> f7 = dataHelper.fetchAndUploadCSV7();
//            CompletableFuture<Void>[] fAll = new CompletableFuture[] {f1, f2, f3, f4, f5, f6, f7};
//            CompletableFuture.allOf(fAll).join();
//            msgResponse.setProcessed(true);
//            msgResponse.setMessageStatus("message");
//        } catch (Exception e) {
//            msgResponse.setMessageStatus(ERROR);
//            msgResponse.setErrorMessage("error");
//        }
//        return msgResponse;
//    }
//
//    public CompletableFuture<Void> fetchAndUploadCSV1() {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                return someService().getAllData1();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).thenAccept(results -> {
//            try {
//                if (results.size() > 0) {
//                    csvWriter.uploadAsCsv(results);
//                }
//                else {
//                    log.info(" No data found..");
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//
//    public <T> void uploadAsCsv(List<T> objectList) throws Exception {
//        long objListSize = ((objectList==null) ? 0 : objectList.size());
//        log.info("Action=Start, objectListSize=" + objListSize);
//        ByteArrayInputStream inputStream = getCsvAsInputStream(objectList);
//        Info fileInfo = someClient.uploadFile(inputStream);
//        log.info("Action=Done, FileInfo=" + ((fileInfo==null ? null : fileInfo.getID())));
//    }

}
