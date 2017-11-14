
dhtmlXGridObject.prototype.EI = function (path, bo) {
	this.load(path, bo, "csv");
};
dhtmlXGridObject.prototype.enableCSVAutoID = function (mode) {
	this.Sz = ap(mode);
};
dhtmlXGridObject.prototype.enableCSVHeader = function (mode) {
	this.KY = ap(mode);
};
dhtmlXGridObject.prototype.setCSVDelimiter = function (str) {
	this.csv.cell = str;
};
dhtmlXGridObject.prototype.Sz = true;
dhtmlXGridObject.prototype.rF = function (str) {
	this.parse(str, "csv");
};
dhtmlXGridObject.prototype.tN = function (NU) {
	this.editStop();
	if (this.oX) {
		this.zt = "getMathValue";
	} else {
		if (this.aaV || NU) {
			this.zt = "getTitle";
		} else {
			this.zt = "getValue";
		}
	}
	var out = [];
	if (this.KY) {
		for (var j = 1; j < this.hdr.rows.length; j++) {
			var a = [];
			for (var i = 0; i < this.gA; i++) {
				if ((!this.nF) || (this.nF[i])) {
					a.push(this.adE(i, j - 1));
				}
			}
			out.push(a.join(this.csv.cell));
		}
	}
	var i = 0;
	var afE = this.aD.length;
	for (i; i < afE; i++) {
		var temp = this.lJ(null, i);
		if (temp != "") {
			out.push(temp);
		}
	}
	return out.join(this.csv.row);
};
dhtmlXGridObject.prototype.lJ = function (r, i, start, end) {
	var out = new Array();
	if (!r) {
		r = this.render_row(i);
		if (this.aC && !this.aC.bj[r.idd]) {
			this.aC.render_row(i);
		}
	}
	if (!this.Sz) {
		out[out.length] = r.idd;
	}
	start = start || 0;
	end = end || this.gA;
	var xJ = false;
	var ind = start;
	while (r.childNodes[start]._cellIndex > ind && start) {
		start--;
	}
	for (var jj = start; ind < end; jj++) {
		if (!r.childNodes[jj]) {
			break;
		}
		var real_ind = r.childNodes[jj]._cellIndex;
		if ((!this.nF) || (this.nF[real_ind])) {
			var DJ = r.childNodes[jj];
			var zx = this.cells(r.idd, real_ind);
			while (ind != real_ind) {
				ind++;
				out.push("");
				if (ind >= end) {
					break;
				}
			}
			if (ind >= end) {
				break;
			}
			ind++;
			if (zx.cell) {
				wF = zx[this.zt]();
			} else {
				wF = "";
			}
			if ((this.Zx) && (zx.hy())) {
				xJ = true;
			}
			out[out.length] = ((wF === null) ? "" : wF);
			if (this.CP && DJ.colSpan && DJ.colSpan > 1) {
				DJ = DJ.colSpan - 1;
				for (var u = 0; u < DJ; u++) {
					out[out.length] = "";
					ind++;
				}
			}
		} else {
			ind++;
		}
	}
	if ((this.xq) && (!xJ)) {
		return "";
	}
	return out.join(this.csv.cell);
};
dhtmlXGridObject.prototype.yP = function (val) {
	if (window.clipboardData) {
		window.clipboardData.setData("Text", val);
	} else {
		(new Clipboard()).copy(val);
	}
};
dhtmlXGridObject.prototype.rD = function () {
	if (window.clipboardData) {
		return window.clipboardData.getData("Text");
	} else {
		return (new Clipboard()).paste();
	}
};
dhtmlXGridObject.prototype.PY = function (cq, nA) {
	if ((!cq) || (!nA)) {
		if (!this.bY[0]) {
			return;
		}
		cq = this.bY[0].idd;
		nA = this.cell._cellIndex;
	}
	var ed = this.cells(cq, nA);
	this.yP(((ed.DB ? ed.DB() : ed.getValue()) || "").toString());
};
dhtmlXGridObject.prototype.DH = function (cq, nA) {
	if ((!cq) || (!nA)) {
		if (!this.bY[0]) {
			return;
		}
		cq = this.bY[0].idd;
		nA = this.cell._cellIndex;
	}
	var ed = this.cells(cq, nA);
	ed[ed.hW ? "setLabel" : "setValue"](this.rD());
};
dhtmlXGridObject.prototype.Sr = function (cq) {
	var out = "";
	if (this.oX) {
		this.zt = "getMathValue";
	} else {
		if (this.aaV) {
			this.zt = "getTitle";
		} else {
			this.zt = "getValue";
		}
	}
	if (cq) {
		out = this.lJ(this.dz(cq));
	} else {
		for (var i = 0; i < this.bY.length; i++) {
			if (out) {
				out += this.csv.row;
			}
			out += this.lJ(this.bY[i]);
		}
	}
	this.yP(out);
};
dhtmlXGridObject.prototype.EE = function (cq) {
	var csv = this.rD();
	if (!csv) {
		return;
	}
	if (cq) {
		var r = this.dz(cq);
	} else {
		var r = this.bY[0];
	}
	if (!r) {
		return;
	}
	csv = (csv.split(this.csv.row)[0]).split(this.csv.cell);
	if (!this.Sz) {
		csv.splice(0, 1);
	}
	for (var i = 0; i < csv.length; i++) {
		var ed = this.cells3(r, i);
		ed[ed.hW ? "setLabel" : "setValue"](csv[i]);
	}
};
dhtmlXGridObject.prototype.IG = function () {
	var csv = this.rD();
	if (!csv) {
		return;
	}
	var z = csv.split(this.csv.row);
	for (var i = 0; i < z.length; i++) {
		if (z[i]) {
			csv = z[i].split(this.csv.cell);
			if (this.Sz) {
				this.hY(this.iD() + 2, csv);
			} else {
				if (this.bj[csv[0]]) {
					csv[0] = this.uid();
				}
				this.hY(csv[0], csv.slice(1));
			}
		}
	}
};
dhtmlXGridObject.prototype.Qd = function () {
	this.yP(this.tN());
};
dhtmlXGridObject.prototype.LJ = function () {
	var csv = this.rD();
	if (!csv) {
		return;
	}
	this.rF(csv);
};
dhtmlXGridObject.prototype.aqV = function (path) {
	if (!this.SM) {
		this.SM = document.createElement("FORM");
		this.SM.action = (path || "") + "xls.php";
		this.SM.method = "post";
		this.SM.target = (_isIE ? "_blank" : "");
		document.body.appendChild(this.SM);
		var apo = document.createElement("INPUT");
		apo.type = "hidden";
		apo.name = "csv";
		this.SM.appendChild(apo);
		var aqf = document.createElement("INPUT");
		aqf.type = "hidden";
		aqf.name = "csv_header";
		this.SM.appendChild(aqf);
	}
	var hA = this.tN();
	this.SM.childNodes[0].value = hA;
	var Bo = [];
	var l = this.gA;
	for (var i = 0; i < l; i++) {
		Bo.push(this.wW(i));
	}
	Bo = Bo.join(",");
	this.SM.childNodes[1].value = Bo;
	this.SM.submit();
};
dhtmlXGridObject.prototype.aem = function (before, asg) {
	var html = "<style>TD {font-family:Arial;text-align:center;padding-left:2px;padding-right:2px;};\n td.filter input, td.filter select {display:none;};\n </style>";
	var st_hr = null;
	if (this.aC) {
		st_hr = [].concat(this._hrrar);
		for (var i = 0; i < this.aC.gA; i++) {
			this._hrrar[i] = null;
		}
	}
	html += "<base href='" + document.location.href + "'></base>";
	if (!this.parentGrid) {
		html += (before || "");
	}
	html += "<table width=\"100%\" border=\"2px\" cellpadding=\"0\" cellspacing=\"0\">";
	var ZZ = Math.max(this.aD.length, this.am.length);
	var Qz = this.gA;
	var width = this.XV();
	html += "<tr class=\"header_row_1\">";
	for (var i = 0; i < Qz; i++) {
		if (this._hrrar && this._hrrar[i]) {
			continue;
		}
		var hcell = this.hdr.rows[1].cells[this.hdr.rows[1].bq ? this.hdr.rows[1].bq[parseInt(i)] : i];
		var colspan = (hcell.colSpan || 1);
		var rowspan = (hcell.rowSpan || 1);
		for (var j = 1; j < colspan; j++) {
			width[i] += width[j];
		}
		html += "<td rowspan=\"" + rowspan + "\" width=\"" + width[i] + "%\" style=\"background-color:lightgrey;\" colspan=\"" + colspan + "\">" + this.wW(i) + "</td>";
		i += colspan - 1;
	}
	html += "</tr>";
	for (var i = 2; i < this.hdr.rows.length; i++) {
		if (_isIE) {
			html += "<tr style='background-color:lightgrey' class='header_row_" + i + "'>";
			var cells = this.hdr.rows[i].childNodes;
			for (var j = 0; j < cells.length; j++) {
				if (!this._hrrar || !this._hrrar[cells[j]._cellIndex]) {
					html += cells[j].outerHTML;
				}
			}
			html += "</tr>";
		} else {
			html += "<tr class='header_row_" + i + "' style='background-color:lightgrey'>" + (this.aC ? this.aC.hdr.rows[i].innerHTML : "") + this.hdr.rows[i].innerHTML + "</tr>";
		}
	}
	for (var i = 0; i < ZZ; i++) {
		html += "<tr>";
		if (this.am[i] && this.am[i].te) {
			html += this.am[i].innerHTML.replace(/<img[^>]*>/gi, "") + "</tr>";
			continue;
		}
		if (this.am[i] && this.am[i].style.display == "none") {
			continue;
		}
		var bO;
		if (this.am[i]) {
			bO = this.am[i].idd;
		} else {
			if (this.aD[i]) {
				bO = this.aD[i].idd;
			} else {
				continue;
			}
		}
		for (var j = 0; j < Qz; j++) {
			if (this._hrrar && this._hrrar[j]) {
				continue;
			}
			if (this.bj[bO] && this.bj[bO].tagName == "TR") {
				var c = this.cells(bO, j);
				if (c.yB) {
					var value = "";
				} else {
					if (c.getContent) {
						value = c.getContent();
					} else {
						if (c.afl || c.combo) {
							var value = c.cell.innerHTML;
						} else {
							var value = c.getValue();
						}
					}
				}
			} else {
				var value = this._get_cell_value(this.aD[i], j);
			}
			var color = this.columnColor[j] ? "background-color:" + this.columnColor[j] + ";" : "";
			var align = this.cellAlign[j] ? "text-align:" + this.cellAlign[j] + ";" : "";
			var cspan = c.getAttribute("colspan");
			html += "<td style=\"" + color + align + "\" " + (cspan ? "colSpan=\"" + cspan + "\"" : "") + ">" + (value === "" ? "&nbsp;" : value) + "</td>";
			if (cspan) {
				j += cspan - 1;
			}
		}
		html += "</tr>";
		if (this.am[i] && this.am[i].wE) {
			var sub = this.cells4(this.am[i].wE.ctrl);
			if (sub.aec) {
				html += "<tr><td colspan=\"" + Qz + "\">" + sub.aec().aem() + "</td></tr>";
			} else {
				html += "<tr><td colspan=\"" + Qz + "\">" + this.am[i].wE.innerHTML + "</td></tr>";
			}
		}
	}
	if (this.ftr) {
		for (var i = 1; i < this.ftr.childNodes[0].rows.length; i++) {
			html += "<tr style='background-color:lightgrey'>" + ((this.aC) ? this.aC.ftr.childNodes[0].rows[i].innerHTML : "") + this.ftr.childNodes[0].rows[i].innerHTML + "</tr>";
		}
	}
	html += "</table>";
	if (this.parentGrid) {
		return html;
	}
	html += (asg || "");
	var d = window.open("", "_blank");
	d.document.write(html);
	d.document.write("<script>window.onerror=function(){return true;}</script>");
	d.document.close();
	if (this.aC) {
		this._hrrar = st_hr;
	}
};
dhtmlXGridObject.prototype.XV = function () {
	var width = [];
	var MG = 0;
	for (var i = 0; i < this.gA; i++) {
		var w = this.yI(i);
		width.push(w);
		MG += w;
	}
	var uZ = [];
	var xI = 0;
	for (var i = 0; i < width.length; i++) {
		var p = Math.floor((width[i] / MG) * 100);
		xI += p;
		uZ.push(p);
	}
	uZ[uZ.length - 1] += 100 - xI;
	return uZ;
};
dhtmlXGridObject.prototype.anp = function (obj) {
};
dhtmlXGridObject.prototype.akQ = function (path) {
};
dhtmlXGridObject.prototype.aeN = function () {
};
dhtmlXGridObject.prototype.aia = function () {
};
if (!window.clipboardData) {
	window.clipboardData = {ahA:function () {
		var clip = Components.classes["@mozilla.org/widget/clipboard;1"].createInstance(Components.interfaces.nsIClipboard);
		if (!clip) {
			return null;
		}
		var trans = Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);
		if (!trans) {
			return null;
		}
		trans.addDataFlavor("text/unicode");
		var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
		this.Pv = [clip, trans, str];
		return true;
	}, setData:function (type, text) {
		try {
			netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
		}
		catch (e) {
			dhtmlxError.gn("Clipboard", "Access to clipboard denied", [type, text]);
			return "";
		}
		if (!this.ahA()) {
			return false;
		}
		this.Pv[2].data = text;
		this.Pv[1].setTransferData("text/unicode", this.Pv[2], text.length * 2);
		var akZ = Components.interfaces.nsIClipboard;
		this.Pv[0].setData(this.Pv[1], null, akZ.kGlobalClipboard);
	}, getData:function (type) {
		try {
			netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
		}
		catch (e) {
			dhtmlxError.gn("Clipboard", "Access to clipboard denied", [type]);
			return "";
		}
		if (!this.ahA()) {
			return false;
		}
		this.Pv[0].getData(this.Pv[1], this.Pv[0].kGlobalClipboard);
		var To = new Object();
		var str = new Object();
		try {
			this.Pv[1].A("text/unicode", str, To);
		}
		catch (e) {
			return "";
		}
		if (str) {
			str = str.value.QueryInterface(Components.interfaces.nsISupportsString);
		}
		if (str) {
			return str.data.substring(0, To.value / 2);
		}
		return "";
	}};
}

