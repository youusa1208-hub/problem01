<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- taglibディレクティブのuri入力は[uri=]まで入力して1秒待つ→候補から選択　--%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Sry08_JSTL</title>
</head>
<%--
	JSTLの基本構文
		非セット	<カテゴリ名:処理名　属性名="値"/>
		非セットの場合、最後に/が必要
	セットの記述は省略
	
	coreカテゴリの処理:
		<c:out>			変数やオフジェクトを出力
		<c:set>			変数やオフジェクトに値を設定
		<c:remove>		変数やオフジェクトを削除
		<c:if>			条件分岐、条件成立時の処理を内容に記述
		<c:choose>		条件分岐、whenやotherwiseと組み合わせて使用
		<c:when>		条件成立時の処理を内容に記述
		<c:otherwise>	whenの条件が全て非成立時の処理を内容に記述
		<c:forEach>		配列やリストの繰り返し処理
		<c:forTokens>	文字列の区切り文字で分割して個別処理
		<c:param>		パラメータを指定
		<c:import>		指定したアドレスのリソースを取り込む
		<c:redirect>	指定したアドレスにリダイレクトする（させる）
		
	fmtカテゴリの処理:
		<fmt:formatNumber>	数値の出力形式を指定
		<fmt:formatDate>	日付時刻データの出力形式を指定
		<fmt:parseNumber>	文字列を数値データに変換
		<fmt:parseDate>		文字列を日付時刻データに変換
		
		formatNumberのpattern属性について
		pattern="○○;●●"
			○○:正の値のパターン
			●●:負の値のパターン
		pattern内の記号
			#:数値,0の場合は省略	（###,###.0000←1620.54の場合
			0:数値,0の場合も出力	→1,620.5400
			;:正の値と負の値のパターン区切り
		
		formatDateのpatternについて
		pattern内の記号(文字)
			y:年		M:月		d:日		E:曜日
			a:AMPM	H:0~23時	　h:0~11時   m:分	ｓ：秒
			w:年間のN週目(2025/01/10→2週目→2)
			W:月間のN週目(2025/02/02→1週目→1)
			D:年間のＮ日目
			Ｆ:第Ｎ～曜日のＮ
			
	fnカテゴリ（El式内でのみ使用する関数）の処理:
		fn:contains 			指定文字が含まれるか
		fn:containsIgnoreCase	指定文字が含まれるか（大文字小文字問わず）
		fn:indexOF				指定文字例の出現位置
		fn:trim					前後の空白を削除
		fn:join					配列を結合(区切り文字を追加)
		fn:replace				文字例置換
		fn:split				文字例長、配列やコレクションのデータ数を取得
		fn:substring			文字例の一部抜粋	
		fn:substringAfter		指定位置以降の抜粋
		fn:substringBefore		指定位置以前の抜粋
		fn:toLowerCase			小文字変換
		fn:toUpperCase			大文字変換
		fn:escapeXml			タグの無害化
****************************************************************************

	<c:out>とEL式の出力について
		<c:out value="${変数名}"/>
		${変数名}
	両方同じ結果になる→EL式のみでよりのでは？
		→状況(値)によって同じ結果にならないものもある（後述）
 --%>
<body>

	値の設定<br>
		<%-- 変数numに値5を代入	 --%>
		<c:set var="num" value="5"/>
	値の出力<br>
		<%-- numを変数として指定する場合、EL式を使う 
			　EL式を使わない場合→文字[num]を出力　　--%>
		num:<c:out value="${num}"/><br>
		num（EL式なし）<c:out value="num"/><br>
	値の設定2<br>
		<c:set var="str" value="ABC"/>
	値の出力2<br>
		<c:out value="${str}"/><br>
	条件分岐<br>
		<%-- 条件式はtest属性に記述する --%>
		<c:if test="${num>5}">
			numは5より大きい<br>
		</c:if>
		<%-- c:ifの条件が成立しない場合の処理を記述したい場合逆の条件のc:ifを記述する必要がある --%>	
		<c:if test="${num<5}">
			numは5以下<br>
		</c:if>
	条件分岐2<br>
		<c:choose>
		<%-- <c:when>は複数記述した場合、先頭から順に判定し条件成立した<c:when>の内容を実施後、
			 <c:chosse>の下に進む
			 条件成立した<c:when>がない場合は<c:chosse>の内容を実行する--%>
		<c:when test="${num>5}">
			numは5より大きい<br>
		</c:when>
		<c:when test="${num>3}">
			numは(5以下かつ)3より大きい<br>
		</c:when>
		<c:otherwise>
			numは3以下<br>
		</c:otherwise>
		</c:choose>
<%
		//listコレクションに値を格納
		List<String> list = Arrays.asList("ラーメン","カレー","ハンバーグ","そば","おかゆ");
		//int(整数)型の配列に初期値を格納
		int[] arr1 = {100,200,333,444,5500,66600,77,888,9,1};
		// HashMapコレクションのインスタンスを整数を生成
		Map<String,String> map = new HashMap<>();
		// HashMapコレクションのインスタンス(map)に値を追加
		map.put("cc", "コーヒー");
		map.put("bb", "ビール");
		map.put("tt", "紅茶");
		// コレクションと配列に属性名を付与
		pageContext.setAttribute("li",list);
		pageContext.setAttribute("ar",arr1);
		pageContext.setAttribute("mp",map);
%>

	listを繰り返し処理<br>
	<%-- items→コレクションや配列を指定
		var→1つずつのデータを格納する変数名の指定 --%>

	<c:forEach items="${li}" var="d">
		<c:out value="${d}"/><br>
	</c:forEach>
	配列を繰り返し処理1<br>
	<c:forEach items="${ar}" var="num">
		<c:out value="${num}"/><br>	
	</c:forEach>
	配列を繰り返し処理2(状態確認)<br>
	<%--
		varStatus:繰り返し処理の状態、属性を格納
			current :varに格納した現在のオブジェクト
			index	:index番号
			count	:表示件数(1~)
			first	:ループの先頭かどうか(true/false)
			last	:ループの最後かどうか(true/false)
			begin	:begin属性の値
			end		:end属性の値
			step	:step属性の値
	 --%>
	 <c:forEach items="${ar}" var="num" varStatus="st">
	 	<c:out value="${st.current}"/>,
	 	<c:out value="${st.index}"/>,
	 	<c:out value="${st.count}"/>,
	 	<c:out value="${st.first}"/>,
	 	<c:out value="${st.last}"/><br>
	 </c:forEach>
	 <hr>
	 条件を指定して繰り返し処理2(条件指定)<br>
	 <c:forEach items="${ar}" var="num" varStatus="st" begin="1" end="8" step="2">
	 	<c:out value="${st.current}"/>,
	 	<c:out value="${st.index}"/>,
	 	<c:out value="${st.count}"/>,
	 	<c:out value="${st.first}"/>,
	 	<c:out value="${st.last}"/>,
	 	<c:out value="${st.begin}"/>,
	 	<c:out value="${st.end}"/>,
	 	<c:out value="${st.step}"/>,
	 	<c:out value="${num}"/><br>
	 </c:forEach>
	<%-- 文字列の設定　--%>
	
	<c:set var="arr" value="a@b@c@d@e@f@g@h"/>
	<%-- token:駒、コマ、ゲームなどのカウンタとして使用したりする、小さいチップのようなもの --%>
	文字列を区切り文字で分割<br>
	<c:forTokens items="${arr}" var="dt" delims="@">
		<c:out value="${dt}"/><br>
	</c:forTokens>
	<%-- <c:forTokens>もvarStatus属性の指定が可能 --%>
	
	↓import↓<br>
	<c:import url="Srv05_inc.jsp"/>
	↑import↑<br><hr>
	
	<%-- <c:import>や<c:redirect>で指定したＵＲＬが送信データを必要とする場合、<c:param>を使って指定する --%>

<%-- 
	<c:redirect url="Srv06_Action_EL.jsp">
		<c:param name="p1" value="aa1"/>
		<c:param name="p2" value="bb2"/>
		<c:param name="p3" value="cc3"/>
		<c:param name="p3" value="dd4"/>
		<c:param name="p3" value="ee5"/>
	</c:redirect>
--%>
	
	値の設定3<br>
		<c:set var="dnum" value="-1694.2466"/>
	c:outで出力<br>
		<c:out value="${dnum}"/><br>
	fmt:formatNumber(初期設定)<br>
		<fmt:formatNumber value="${dnum}"/><br>
	<%--
		<fmt:formatNumber>の初期設定の表示
			→数値として表示
				・整数値の3桁区切り用の「,」を表示
				・小数点第3位までの表示(第4位は四捨五入で丸める)
	 --%>
	 
	 fmt:formatNumber<br>
	 pattern:△###,###.0000;▼###,###.0000<br>
	 	<fmt:formatNumber value="${dnum}"
	 		pattern="△###,###.0000;▼###,###.0000"/><br>
	 maxIntD:3,maxFraD:3<br>
	 	<fmt:formatNumber value="${dnum}"
	 		maxIntegerDigits="3" maxFractionDigits="3"/><br>
	 <%--
	 	maxIntegerDigits→整数値の最大桁数
	 	maxFractionDigits→小数点数の最大桁数
	  --%>
	  
	 <hr>
	 
	 <%-- 現在の日付時刻 --%>
	 <%-- dateという変数を宣言(インスタンスを生成)型はjava.util.Date --%>
	 	<jsp:useBean class = "java.util.Date" id="date"/>
	 <%--
	 	<jsp:useBean class="変数の型を指定" id="変数名"/>
	 	→変数はEL式で使用可能、スクリプトレットで記述した場合、以下になる
	 		java.util.Date date = new java.util.Date();
	 		pageContext.setAttribute("date",date);
	  --%>
	 
	 fmt:formatDate(初期表示)<br>
	 	<fmt:formatDate value="${date}"/><br>
	 fmt:formatDate<br>
	 pattern:yyyy/MM/dd HH:mm:ss<br>
	 	<fmt:formatDate value="${date}" 
	 		pattern="yyyy/MM/dd HH:mm:ss"/><br>
	 pattern:yy年M月d日<br>
	 	<fmt:formatDate value="${date}"
	 		pattern="yy年M月d日"/><br>
	 <hr>
	 
	 EL式関数<br>
	 値の設定4<br>
	 	<c:set var="str1" value="ABCDEFG"/>
	 str1:<c:out value="${str1}"/><br>
	 fn:contains(str1,DEF)<br>
	 	<c:out value="${fn:contains(str1,'DEF')}"/><br>
	 fn:contains(str1,def)<br>
	 	<c:out value="${fn:contains(str1,'def')}"/><br>
	 fn:containsIgnoreCase(str1,DEF)<br>
	 	<c:out value="${fn:containsIgnoreCase(str1,'DEF')}"/><br>
	 fn:containsIgnoreCase(str1,def)<br>
	 	<c:out value="${fn:containsIgnoreCase(str1,'def')}"/><br>
	 fn:containsIgnoreCase(str1,fh)<br>
	 	<c:out value="${fn:containsIgnoreCase(str1,'fgh')}"/><br>
	 <hr>
	 
	 <%-- 結果を変数に格納 --%>
	 	<c:set var="result1" value="${fn:containsIgnoreCase(str1,'DEF')}"/>
	 result1:<c:out value="${result1}"/><br>
	 <hr>
	 
	 <%-- indexOf(文字例、検索対象):検索対象が文字列のどの位置にあるか --%>
	 
	 fn:indexOf(str1,DEF)<br>
	 	<c:out value="${fn:indexOf(str1,'DEF')}"/><br>
	 fn:indexOf(str1,def)<br>
	 	<c:out value="${fn:indexOf(str1,'def')}"/><br>
	 fn:indexOf(str1,ABC)<br>
	 	<c:out value="${fn:indexOf(str1,'ABC')}"/><br>
	 <%-- 位置を取得する処理の場合、
	 		先頭の文字位置:0→見つからない時:-1
	 		先頭の文字位置:1→見つからない時:0
	 --%>
	 <%-- 大文字小文字を気にせずに探す方法はないのか？
	 		処理を組み合わせて対応する
	 		fn:toUpperCase(文字例)→指定した文字例を大文字に変換
	 		fn:toLowerCase(文字例)→指定した文字例を小文字に変換
	  --%>
	  fn:indexOf(fn:toUpperCase(str1),fn:toUpperCase(def))<br>
	  	<c:set var="upcase" value="${fn:toUpperCase(str1)}"/>
	  	<c:set var="updef" value="${fn:toUpperCase('def')}"/>
	  	<c:out value="${fn:indexOf(upcase,updef)}"/><br>
	  	upcase:<c:out value="${upcase}"/><br>
	  	updef:<c:out value="${updef}"/><br>
	  <hr>
	 <%-- fn:replace(文字例、検索対象、置換後の文字例 
	 	文字例内の検索対象を置換後の文字例に変換、その形式を返す　--%>
	 	
	 fn:replace(str1,DEF,XYZ)<br>
	 	<c:set var="rp1" value="${fn:replace(str1,'DEF','XYZ')}"/>
	 	<c:out value="${rp1}"/><br><br>
	 str2:ABCDEFABCDEFABCDEF<br>
	 	<c:set var="str2" value="ABCDEFABCDEFABCDEF"/>
	 fn:replace(str2,DEF,XYZ)<br>
	 	<c:set var="rp2" value="${fn:replace(str2,'DEF','XYZ')}"/>
	 	<c:out value="${rp2}"/><br>
	 <hr>
	 <%-- fn:substring(文字例、開始位置、終了位置)　文字例の開始位置から終了位置の手前までを取得し、返す --%>
	 <c:out value="${str2}"/><br>
	 
	 <% for(int i=0;i<10;i++){
		 	out.print(i);
	 	}
	 %><br>
	 <hr>
	 
	 fn:substring(str2,2,6)<br>
	 	<c:set var="subst1" value="${fn:substring(str2,2,6)}"/>
	 	<c:out value="${subst1}"/><br>
	 str3:ABCDEFGHIJKLMNOP<br>
	 	<c:set var="str3" value="ABCDEFGHIJKLMNOP"/>
	 fn:substringAfter(str3,GHI)<br>
	 	<c:set var="subst2" value="${fn:substringAfter(str3,'GHI')}"/>
	 	<c:out value="${subst2}"/><br>
	 fn:substringBefore(str3,GHI)<br>
	 	<c:set var="subst3" value="${fn:substringBefore(str3,'GHI')}"/>
	 	<c:out value="${subst3}"/><br>
	 <hr><hr>
	 	<c:set var="alert" value="<script>alert('warning!');</script>"/>
	 	c:out<c:out value="${alert}"/><br>
	 	el:${alert}<br>
	 fn:escapeXml:${fn:escapeXml(alert)}<br>
	 <br><br><br>
	 
	 <%--
	 	<script></script>→JavaScriptを内容に記述するタグ
	 						↓
	 		これを実行できる状態にすると、セキュリティ上の問題が発生する
	 						↓
	 		JavaScriptは実行出来ないほうが良い？
	 						↓
	 		「入力した値をそのまま出力出来ないほうがよい」
	 						↓
	 					？？？？？？
	 					
	 	ユーザーが入力/送信した値をJavaScriptとして実行出来る状態がセキュリティ上の問題
	 		→ユーザーが入力/送信した値にタグの記述があったときに実行出来ない形式に変更するのが<c:out>,fn:escapeXml()
	 	
	 	また、ユーザーが入力した値をDB/ファイルに保存
	 		→そこから取得した値を出力した場合も、セキュリティ上の問題になる
	 			→ユーザーが入力した値を出力、DBやファイルに保存した値を出力する場合は
	 				<c:out>,fn:escapeXml()で無害化(sanitize:サニタイズ)するのがよい
	 				
	 				
	 	プログラム上のサニタイズはセキュリティ上の脆弱性を利用したウィルス感染などを発生させないように対応することを指す
	 	
	 	・<c:out>を使用する場合,fn:escapeXml()の記述は不要
	 	・radioボタン、checkbox、selectの値はページ作成者が指定済みの値なんおで、サニタイズの必要はない
	 		→text,textarea,ファイルの値,DBの値はユーザーが入力した値の可能性が高いため、対策が必要
	 	
	 	ユーザーが入力した値に対して、脆弱性が残ったままのページ
	 		→その脆弱性を利用したWebサイトへの攻撃などのことをXSS（cross site scripting:クロスサイトスクリプティング）と呼ぶ
	 	
	 		
	  --%>
</body>
</html>