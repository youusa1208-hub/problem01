<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv06_Action_EL</title>
</head>
<%--
	JSPアクションタグ:あらかじめ決められた処理を実施するためのJSP専用アクションタグの構文
		セットのタグ		<ｊｓｐ：アクション名　属性名1="値"　属性名2="値">
					</jsp:アクション名>
		非セットのタグ	<ｊｓｐ：アクション名　属性名1="値"　属性名2="値"/>
	
	アクションタグの例:<jsp:forward page="遷移先のページ"/>
				jsp:forward→ページ遷移する
				遷移先のページにパラメータ(値)を渡す場合
				<jsp:forward page="遷移先のページ">
					<jsp:param name="パラメータ名"　value="値"/>
				<jsp:forward >
				いつつかうのか？
				例えばログイン画面のIDとパスワードが正しい場合に
				会員情報のページに遷移
				
	ページの遷移方法(２種類)について
		・forward
			→同じサーバー内で情報を渡して遷移する
			遷移先の結果を返す
				（クライアントの要求1回→サーバーの応答1回）
		・redirect
			→サーバー(A)から応答を返す
			→応答の情報内に、次の要求先が指定されている
			→クライアントは次の要求先に要求
			→次のサーバー(B)から応答を返す
				(クライアントの要求1+1（2回）
					→サーバーの応答1(A)+1(B)回(2回))
				この場合はサーバーは同じでなくもよい
			アドレス(URL)は次の要求先(B)が表示される
	
	遷移方法の違いを知ることで、データの保持方法の違いを理解できる
		(request,session,page,application)
			→後々説明します
	
	ページの遷移方法は
		・アクションタグ（<jsp:forward>）
		・リンク(<a>)
		・フォームの送信先(action属性)
		・サーブレットのRequestDispatcher などが存在する		
 --%>
 <%-- 
 	EL式について:Expression　Language→EL
 		値の出力などを簡単に行う方法
 	<%=値 %>　式スクリプト
 	$｛値｝	EL式
 	<h<%=i%>>見出し</h<%=i%>>
 	<h${i}>見出し</h${i}> 	
 	
 	${変数名},${式},${オブジェクト.プロパティ}などの記述も可能
 	
 --%>
 <%-- 
 	EL式で使用可能な算術式、記号
 	算術:+,-,*,/(div),%(mod)
 	比較:==(ep),!=(ne),<(lt),>(gt),<=(le),>=(ge)
 	論理:&&(and),||(or),!(not)
 	検証:empty
 		(プロパティなどを判定、存在しない場合:true、存在する場合:falseを返す)
 		
 		存在する場合にtrueを返すようにするには
 			${!empty 判定対象}
 			または
			${not empty 判定対象}
 	
 	使用例:
 	${100},${100mod7}
 	${10+15>20},${10+15gt20}
 	${10+15<20},${10+15lt20}
 	
 	EL式内で使用可能な暗黙オブジェクト
 	暗黙オブジェクト:定義しないで使用可能な変数
 	pageScope :ページ属性
 	requestScope:リクエスト属性
 	sessionScope:セッション属性
 	applicationScope:アプリケーションコンテキスト属性
 	pagecontext:JSPのコンテキスト(現在のページ内容)
 	param:リクエストパラメータ(送信データ)
 	paramValues:リクエストパラメータ(同じ送信名の値の配列)
 	
 --%>
<body>

<%
	List<String> list = Arrays.asList("月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日");
	
//	Listコレクションのインスタンス(オブジェクト)にliという属性名を付与し、pagecontextに格納
//		→スクリプトレットで宣言した変数がＥＬ式で使用可能になる
	pageContext.setAttribute("li", list);

//	Mapコレクション
	Map<String,String> map = new HashMap<>();
//	変数mapに値を格納する場合
//	map.put(key,value)
	map.put("dog", "ワオーン!");
	map.put("cat", "シャー!");
	map.put("lion", "ガオー!");
	map.put("pig", "ブー!");
	
	pageContext.setAttribute("animal",map);
%>
<!--	EL式で出力	  -->
	li[3]:${li[3]}<br>
<!--	式スクリプトで出力	  -->
	<%=list.get(3) %><br>
<hr>
	動物の鳴き声
<br>
<!-- 属性名.keyの形式でvalueを取得可能 -->
	犬:${animal.dog}<br>
	猫:${animal.cat}<br>
	ライオン:${animal.lion}<br>
	豚:${animal.pig}<br>
<!-- 属性名["key"]の形式でvalueを取得可能 -->
	犬:${animal["dog"]}<br>
	猫:${animal["cat"]}<br>
	ライオン:${animal["lion"]}<br>
	豚:${animal["pig"]}<br>
<hr>
	暗黙オブジェクトの値を取得→出力<br>
	param.p1:${param.p1}<br>
	param.p2:${param.p2}<br>
	paramValues.p3[0]:${paramValues.p3[0]}<br>
	paramValues.p3[1]:${paramValues.p3[1]}<br>
	paramValues.p3[2]:${paramValues.p3[2]}<br>
	
<hr>
	emptyについて<br>
	${empty param.p1}<br>
	${!empty param.p1}<br>
	${not empty param.p1}<br>
 
<%-- <jsp:forward page="Srv05_Jsp.jsp"/> --%>

<%--
<jsp:forward page="Srv03_Param2">
	<jsp:param name="t1" value="abc"/>
	<jsp:param name="t2" value="def"/>
</jsp:forward>
--%>
</body>
</html>