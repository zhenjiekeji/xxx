var grids = new Array();
function dhtmlXGridFromTable(obj, init) {
	if (typeof (obj) != "object") {
		obj = document.getElementById(obj);
	}
	obj.className = "";
	var w = document.createElement("DIV");
	w.setAttribute("width", obj.getAttribute("gridWidth") || (obj.offsetWidth ? (obj.offsetWidth + "px") : 0) || (window.getComputedStyle ? window.getComputedStyle(obj, null)["width"] : (obj.currentStyle ? obj.currentStyle["width"] : 0)));
	w.setAttribute("height", obj.getAttribute("gridHeight") || (obj.offsetHeight ? (obj.offsetHeight + "px") : 0) || (window.getComputedStyle ? window.getComputedStyle(obj, null)["height"] : (obj.currentStyle ? obj.currentStyle["height"] : 0)));
	var mr = obj;
	var drag = obj.getAttribute("dragAndDrop");
	mr.parentNode.insertBefore(w, mr);
	var f = mr.getAttribute("name") || ("name_" + (new Date()).valueOf());
	var dY = new dhtmlXGridObject(w);
	window[f] = dY;
	var Xn = mr.getAttribute("onbeforeinit");
	var akP = mr.getAttribute("oninit");
	if (Xn) {
		eval(Xn);
	}
	dY.setImagePath(mr.getAttribute("imgpath") || "");
	if (init) {
		init(dY);
	}
	var Dp = mr.rows[0];
	var za = "";
	var zb = "";
	var zc = "";
	var zd = "";
	var ze = "";
	/* add by lfjin, user can config filterSrt by html attribute. Also use by adjust column width which has a filter */
	var filterStr="";
	var enableTooltipsStr = "";
	for (var i = 0; i < Dp.cells.length; i++) {
		za += (za ? "," : "") + Dp.cells[i].innerHTML;
		var width = Dp.cells[i].getAttribute("width") || Dp.cells[i].offsetWidth || (window.getComputedStyle ? window.getComputedStyle(Dp.cells[i], null)["width"] : (Dp.cells[i].currentStyle ? Dp.cells[i].currentStyle["width"] : 0));
		 
		zb += (zb ? "," : "") + (width == "*" ? width : parseInt(width));
		zc += (zc ? "," : "") + (Dp.cells[i].getAttribute("align") || "left");
		zd += (zd ? "," : "") + (Dp.cells[i].getAttribute("type") || "ro");
		ze += (ze ? "," : "") + (Dp.cells[i].getAttribute("sort") || "str");
		filterStr += (filterStr ? "," : "") + (Dp.cells[i].getAttribute("filter") || "");
		enableTooltipsStr += (enableTooltipsStr ? "," : "") + (Dp.cells[i].getAttribute("tooltips") || true);
		var aoM = Dp.cells[i].getAttribute("format");
		if (aoM) {
			if (Dp.cells[i].getAttribute("type").toLowerCase().indexOf("calendar") != -1) {
				dY.RY = aoM;
			} else {
				dY.kr(aoM, i);
			}
		}
		
		 /* add by lfjin. if the column has a select_filter, its width add by 15 use to display the whole word in the combolist */
		var fss = filterStr ? dY.ZK(filterStr):null;
		if (fss && fss[i]) {
		  if (fss[i] == "#select_filter") {
		      width = (width == "*" ? width : parseInt(width) + 15);
		  }
		}
	}
	dY.setHeader(za);
	dY.setInitWidths(zb);
	dY.setColAlign(zc);
	dY.setColTypes(zd);
	if (obj.getAttribute("ColsTitle")=="true") {
	dY.setColumnColor("#CCE2FE");
	}
	/* add by lqmu, user can config ColSorting by html attribute*/
	if (obj.getAttribute("colSorting")) {
		dY.setColSorting(ze);
	}
	if (obj.getAttribute("gridHeight") == "auto") {
		dY.enableAutoHeigth(true);
	}
	/* add by lfjin, user can config enableAutoWidth by gridWidth attribute with value 'auto' */
	if (obj.getAttribute("gridWidth")  == "auto") {
        dY.enableAutoWidth(true);
    }
	if (obj.getAttribute("gridHeight") == "auto") {
		dY.enableAutoHeigth(true);
	}
	if (obj.getAttribute("multiline")) {
		dY.enableMultiline(true);
	}
	var aoP = mr.getAttribute("lightnavigation");
	if (aoP) {
		dY.enableLightMouseNavigation(aoP);
	}
	var ahF = mr.getAttribute("evenrow");
	var afz = mr.getAttribute("unevenrow");
	if (ahF || afz) {
		dY.enableAlterCss(ahF, afz);
	}
	if (drag) {
		dY.enableDragAndDrop(true);
	}
	if (filterStr) {
		dY.attachHeader(filterStr);
	}
	dY.HG(true);//enableColumnAutoSize
	if(mr.getAttribute("multiSelectByCB"))
	{
		dY.attachEvent("onCheckbox",mr.getAttribute("multiSelectByCB"));
		dY.enableMultiselect(true);
		dY.submitOnlySelected(true);
		dY.submitOnlyRowID(true);
	}
	if(obj.getAttribute("groupFormat")){
		dY.yW=function(text,count){return eval(obj.getAttribute("groupFormat"));};
	}
	dY.init();
	if (obj.getAttribute("split")) {
		dY.tT(obj.getAttribute("split"));
	}
	dY._process_inner_html(mr, 1);
	if (akP) {
		eval(akP);
	}
	if (obj.parentNode && obj.parentNode.removeChild) {
		obj.parentNode.removeChild(obj);
	}
	/* add by lfjin, user can config filterSrt by html attribute*/
	if(obj.getAttribute("footerStr")){
		dY.attachHeader(obj.getAttribute("FooterStr"),"" ,"_aFoot");
		/*
		If automatically calculated values were added after grid's initialization,
		the user can force recalculation using the following command:
		*/
		dY.callEvent("onGridReconstructed",[])
	}
	if(obj.getAttribute("EnableHeaderMenu") == "true"){
		dY.enableHeaderMenu();
	}
	if(obj.getAttribute("EnableColumnMove") == "true"){
		dY.enableColumnMove(true);
	}
	if(obj.getAttribute("splitAt")){
		dY.tT(obj.getAttribute("splitAt"));
	}
	if(obj.getAttribute("groupBy")){
		dY.OI(obj.getAttribute("groupBy"));
		//dY.KU();默认显示全部展开，要全部收起的话取消注释
	}
	if(obj.getAttribute("ColumnHidden")){
		dY.setColumnHidden(obj.getAttribute("ColumnHidden"),true);
	}
	if(obj.getAttribute("SmartRendering")){
	    dY.enableSmartRendering(true, obj.getAttribute("SmartRendering"));
	}
	if(enableTooltipsStr != ""){
		dY.aja(enableTooltipsStr);
	}
	grids.push(dY);
	return dY;
}
dhtmlXGridObject.prototype._process_html = function (xml) {
	if (xml.tagName && xml.tagName == "TABLE") {
		return this._process_inner_html(xml, 0);
	}
	var temp = document.createElement("DIV");
	temp.innerHTML = xml.ai.responseText;
	var mr = temp.getElementsByTagName("TABLE")[0];
	this._process_inner_html(mr, 0);
};
dhtmlXGridObject.prototype._process_inner_html = function (mr, start) {
	var arI = mr.rows.length;
	for (var j = start; j < arI; j++) {
		var id = mr.rows[j].getAttribute("id") || j;
		this.aD.push({idd:id, data:mr.rows[j], _parser:this._process_html_row, _locator:this._get_html_data});
	}
	this.render_dataset();
	this.setSizes();
};
dhtmlXGridObject.prototype._process_html_row = function (r, xml) {
	var pg = xml.getElementsByTagName("TD");
	var cD = [];
	r._attrs = this._xml_attrs(xml);
	for (var j = 0; j < pg.length; j++) {
		var tU = pg[j];
		var aoT = tU.getAttribute("type");
		if (r.childNodes[j]) {
			if (aoT) {
				r.childNodes[j].zk = aoT;
			}
			r.childNodes[j]._attrs = this._xml_attrs(pg[j]);
		}
		if (tU.firstChild) {
			cD.push(tU.innerHTML);
		} else {
			cD.push("");
		}
		if (tU.colSpan > 1) {
			r.childNodes[j]._attrs["colspan"] = tU.colSpan;
			for (var k = 1; k < tU.colSpan; k++) {
				cD.push("");
			}
		}
	}
	for (j < pg.length; j < r.childNodes.length; j++) {
		r.childNodes[j]._attrs = {};
	}
	this.VQ(r, (this._c_order ? this.Xb(cD) : cD));
	return r;
};
dhtmlXGridObject.prototype._get_html_data = function (data, ind) {
	data = data.firstChild;
	while (true) {
		if (!data) {
			return "";
		}
		if (data.tagName == "TD") {
			ind--;
		}
		if (ind < 0) {
			break;
		}
		data = data.nextSibling;
	}
	return (data.firstChild ? data.firstChild.data : "");
};
dhtmlxEvent(window, "load", function () {
	var z = document.getElementsByTagName("table");
	for (var a = 0; a < z.length; a++) {
		if (z[a].className == "dhtmlxGrid") {
			dhtmlXGridFromTable(z[a]);
		}
	}
});

