package GUI.GUI_Carpool;

import java.io.File;

public class Delete_Data_GA_input {

	public static void main() {
		// TODO Auto-generated method stub
		delAllFile("data");
		delAllFile("GA_input");
		System.out.println("Delete OK");
	}

	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先刪除資料夾裡面的檔
				 delFolder(path+"/"+ tempList[i]);//再刪除空資料夾
			}
		}
	}

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 刪除完裡面所有內容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 刪除空資料夾

		} catch (Exception e) {
			System.out.println("刪除資料夾操作出錯");
			e.printStackTrace();

		}

	}

}
