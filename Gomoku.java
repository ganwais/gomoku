import java.util.Scanner;
public class Gomoku{
	public static void main(String[] args){
		int a = 1;
		Scanner myScanner =new Scanner(System.in);
		int arr[][];
		System.out.println("请输入想要棋盘的大小");
		int b = myScanner.nextInt();
		arr = new int[b][b];
		for( int i = 0 ; i < arr.length ; i++ ){
			for( int j = 0 ; j < arr[i].length ; j++ ){
				arr[i][j] = 0 ;
			}
		}
		do{
			//输入系统
			System.out.println(a + "号阵营请选择要放置方格的行数(x)");
			int x = myScanner.nextInt();
			System.out.println(a + "号阵营请选择要放置方格的列数(y)");
			int y = myScanner.nextInt();
			//输入报错
			if( (x < 1 || x > arr.length) ||
				(y < 1 || y > arr[1].length) ){
				System.out.println("输入有误,请重新输入合理范围内的行与列(1~6)");
				continue;
			}
			if( arr[x-1][y-1] != 0){
				System.out.println("此位置已经被占用,请重新选择其他位置");
				continue;
			}

				arr[x-1][y-1] = a;


			//打印棋盘
			for( int i = 0 ; i < arr.length ; i++ ){
				for( int j = 0 ; j < arr[i].length ; j++ ){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}


			//判断胜利系统
			for( int i = 0 ; i < arr.length - 4 ; i++ ){
				for( int j = 0 ; j < arr[i].length  - 4 ; j++ ){
					if( arr[i][j] == a ){
						if( arr[i+4][j+4] == a){
							if( arr[i+1][j+1] == a && arr[i+2][j+2] == a && arr[i+3][j+3] == a){ //斜着五个
								System.out.println(a + "阵营获胜!");
								return;
							}
						}
						if( arr[i+4][j] == a){
							if( arr[i+1][j] == a && arr[i+2][j] == a && arr[i+3][j] == a){		//竖着五个
								System.out.println(a + "阵营获胜!");
								return;
							}
						}
						if( arr[i][j+4] == a){
							if( arr[i][j+1] == a && arr[i][j+2] == a && arr[i][j+3] == a){		//横着五个
								System.out.println(a + "阵营获胜!");
								return;
							}
						}
					}
				}
			}


			//下棋手轮换系统
			if( a == 1){		
				a = 2;
			}else{
				a = 1;
			}
		}while(true);
	}
}