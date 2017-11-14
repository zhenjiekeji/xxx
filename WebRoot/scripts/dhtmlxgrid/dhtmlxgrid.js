
var globalActiveDHTMLGridObject;
String.prototype.PA = function () {
	return this.replace(/&nbsp;/g, " ").replace(/(^[ \t]*)|([ \t]*$)/g, "");
};
function dhtmlxArray(ar) {
	return dhtmlXHeir((ar || new Array()), dhtmlxArray._master);
}
dhtmlxArray._master = {bP:function (aiw) {
	for (var i = 0; i < this.length; i++) {
		if (aiw == this[i]) {
			return i;
		}
	}
	return -1;
}, ml:function (ind, value) {
	this[this.length] = null;
	for (var i = this.length - 1; i >= ind; i--) {
		this[i] = this[i - 1];
	}
	this[ind] = value;
}, hd:function (ind) {
	this.splice(ind, 1);
}, yk:function (akv, dQ) {
	var YV = this[akv];
	this[akv] = this[dQ];
	this[dQ] = YV;
}};
function dhtmlXGridObject(id) {
	if (_isIE) {
		try {
			document.execCommand("BackgroundImageCache", false, true);
		}
		catch (e) {
		}
	}
	if (id) {
		if (typeof (id) == "object") {
			this.aL = id;
			this.aL.id = "cgrid2_" + this.uid();
		} else {
			this.aL = document.getElementById(id);
		}
	} else {
		this.aL = document.createElement("DIV");
		this.aL.id = "cgrid2_" + this.uid();
	}
	this.aL.innerHTML = "";
	dhtmlxEventable(this);
	var self = this;
	this.Wr = 0;
	this.cell = null;
	this.row = null;
	this.iconURL = "";
	this.editor = null;
	this.UB = true;
	this.aP = true;
	this.combos = new Array(0);
	this.QL = new Array(0);
	this.bj = {};
	this.aD = dhtmlxArray();
	this.am = dhtmlxArray();
	this._data_cache = {};
	this.XC = {};
	this._ud_enabled = true;
	this.bA = new ag(this.vj, this, true, this.ir);
	this._maskArr = [];
	this.bY = dhtmlxArray();
	this.bH = {};
	this.vw = this.BN = 0;
	this.aL.className += " gridbox";
	this.aL.style.width = this.aL.getAttribute("width") || (window.getComputedStyle ? (this.aL.style.width || window.getComputedStyle(this.aL, null)["width"]) : (this.aL.currentStyle ? this.aL.currentStyle["width"] : this.aL.style.width || 0)) || "100%";
	this.aL.style.height = this.aL.getAttribute("height") || (window.getComputedStyle ? (this.aL.style.height || window.getComputedStyle(this.aL, null)["height"]) : (this.aL.currentStyle ? this.aL.currentStyle["height"] : this.aL.style.height || 0)) || "100%";
	this.aL.style.cursor = "default";
	this.aL.onselectstart = function () {
		return false;
	};
	var t_creator = function (name) {
		var t = document.createElement("TABLE");
		t.cellSpacing = t.cellPadding = 0;
		t.style.cssText = "width:100%;table-layout:fixed;";
		t.className = name.substr(2);
		return t;
	};
	this.obj = t_creator("c_obj");
	this.hdr = t_creator("c_hdr");
	this.hdr.style.marginRight = "20px";
	this.hdr.style.paddingRight = "20px";
	this.HF = document.createElement("DIV");
	this.HF.style.width = "100%";
	this.HF.style.overflow = "auto";
	this.HF.appendChild(this.obj);
	this.HF.className = "objbox";
	this.kR = document.createElement("DIV");
	this.kR.style.width = "100%";
	this.kR.style.height = "25px";
	this.kR.style.overflow = "hidden";
	this.kR.className = "xhdr";
	this.sf = new Array(0);
	this.gB = document.createElement("IMG");
	this.gB.style.display = "none";
	this.kR.appendChild(this.gB);
	this.kR.appendChild(this.hdr);
	this.kR.style.position = "relative";
	this.aL.appendChild(this.kR);
	this.aL.appendChild(this.HF);
	this.aL.grid = this;
	this.HF.grid = this;
	this.kR.grid = this;
	this.obj.grid = this;
	this.hdr.grid = this;
	this.cellWidthPX = [];
	this.cellWidthPC = [];
	this.fL = this.aL.ajW || "px";
	this.gX = this.aL.delimiter || ",";
	this.oU = ",";
	this.hdrLabels = [];
	this.columnIds = [];
	this.columnColor = [];
	this._hrrar = [];
	this.cellType = dhtmlxArray();
	this.cellAlign = [];
	this.initCellWidth = [];
	this.fldSort = [];
	this.ig = (_isIE && (document.compatMode != "BackCompat") ? 22 : 20);
	this.eg = window.fe || "";
	this.ft = false;
	this.isEditable = true;
	this.pH = false;
	this.aW = false;
	this.cu = 0;
	dhtmlxEvent(window, "unload", function () {
		try {
			if (self.fA) {
				self.fA();
			}
		}
		catch (e) {
		}
	});
	this.setSkin = function (name) {
		this.skin_name = name;
		this.aL.className = "gridbox gridbox_" + name;
		this.skin_h_correction = 0;
		this.enableAlterCss("ev_" + name, "odd_" + name, this.gY());
		this._fixAlterCss();
		switch (name) {
		  case "clear":
			this.FD = document.createElement("DIV");
			this.FD.className = "topMumba";
			this.FD.innerHTML = "<img style='left:0px' src='" + this.eg + "skinC_top_left.gif'><img style='right:20px' src='" + this.eg + "skinC_top_right.gif'>";
			this.aL.appendChild(this.FD);
			this.Gc = document.createElement("DIV");
			this.Gc.className = "bottomMumba";
			this.Gc.innerHTML = "<img style='left:0px' src='" + this.eg + "skinD_bottom_left.gif'><img style='right:20px' src='" + this.eg + "skinD_bottom_right.gif'>";
			this.aL.appendChild(this.Gc);
			this.aL.style.position = "relative";
			this.skin_h_correction = 20;
			break;
		  case "dhx_skyblue":
		  case "dhx_web":
		  case "glassy_blue":
		  case "dhx_black":
		  case "dhx_blue":
		  case "modern":
		  case "light":
			this.ig = 20;
			this.qW = true;
			break;
		  case "xp":
			this.qW = true;
			if ((_isIE) && (document.compatMode != "BackCompat")) {
				this.ig = 25;
			} else {
				this.ig = 22;
			}
			break;
		  case "mt":
			if ((_isIE) && (document.compatMode != "BackCompat")) {
				this.ig = 25;
			} else {
				this.ig = 22;
			}
			break;
		  case "gray":
			if ((_isIE) && (document.compatMode != "BackCompat")) {
				this.ig = 22;
			}
			break;
		  case "sbdark":
			break;
		}
		if (_isIE && this.hdr) {
			var d = this.hdr.parentNode;
			d.removeChild(this.hdr);
			d.appendChild(this.hdr);
		}
		this.setSizes();
	};
	if (_isIE) {
		this.vq(true);
	}
	if (window.dhtmlDragAndDropObject) {
		this.ae = new dhtmlDragAndDropObject();
	}
	this._doOnScroll = function (e, mode) {
		this.callEvent("onScroll", [this.HF.scrollLeft, this.HF.scrollTop]);
		this.BD(e, mode);
	};
	this.BD = function (e, mode) {
		this.kR.scrollLeft = this.HF.scrollLeft;
		if (this.ftr) {
			this.ftr.parentNode.scrollLeft = this.HF.scrollLeft;
		}
		if (mode) {
			return;
		}
		if (this.ahK) {
			if (this.ee) {
				window.clearTimeout(this.ee);
			}
			this.ee = window.setTimeout(function () {
				if (self._update_srnd_view) {
					self._update_srnd_view();
				}
			}, 100);
		}
	};
	this.qu = function (obj) {
		obj.appendChild(this.globalBox ? this.globalBox : this.aL);
		this.setSizes();
	};
	this.init = function (fl) {
		if ((this.gY()) && (!this._h2)) {
			this._h2 = new dhtmlxHierarchy();
			if ((this.aC) && (!this.nh)) {
				this.aC._h2 = this._h2;
			}
			this.kj = {eg:null};
		}
		if (!this.Oi) {
			return;
		}
		this.editStop();
		this.Ms = null;
		this.resized = null;
		this.ij = this.yH = null;
		this.cellWidthPX = [];
		this.cellWidthPC = [];
		if (this.hdr.rows.length > 0) {
			this.clearAll(true);
		}
		var hdrRow = this.hdr.insertRow(0);
		for (var i = 0; i < this.hdrLabels.length; i++) {
			hdrRow.appendChild(document.createElement("TH"));
			hdrRow.childNodes[i]._cellIndex = i;
			hdrRow.childNodes[i].style.height = "0px";
		}
		if (_isIE && _isIE < 8) {
			hdrRow.style.position = "absolute";
		} else {
			hdrRow.style.height = "auto";
		}
		var hdrRow = this.hdr.insertRow(cn ? 2 : 1);
		hdrRow.bq = new Array();
		var kO = 0;
		for (var i = 0; i < this.hdrLabels.length; i++) {
			hdrRow.bq[i] = i - kO;
			if ((this.hdrLabels[i] == this.JP) && (i != 0)) {
				if (cn) {
					hdrRow.insertCell(i - kO);
				}
				hdrRow.cells[i - kO - 1].colSpan = (hdrRow.cells[i - kO - 1].colSpan || 1) + 1;
				hdrRow.childNodes[i - kO - 1]._cellIndex++;
				kO++;
				hdrRow.bq[i] = i - kO;
				continue;
			}
			hdrRow.insertCell(i - kO);
			hdrRow.childNodes[i - kO]._cellIndex = i;
			hdrRow.childNodes[i - kO]._cellIndexS = i;
			this.adA(i, this.hdrLabels[i]);
		}
		if (kO == 0) {
			hdrRow.bq = null;
		}
		this.gA = this.hdrLabels.length;
		if (_isIE) {
			window.setTimeout(function () {
				if (self.setSizes) {
					self.setSizes();
				}
			}, 1);
		}
		if (!this.obj.firstChild) {
			this.obj.appendChild(document.createElement("TBODY"));
		}
		var If = this.obj.firstChild;
		if (!If.firstChild) {
			If.appendChild(document.createElement("TR"));
			If = If.firstChild;
			if (_isIE && _isIE < 8) {
				If.style.position = "absolute";
			} else {
				If.style.height = "auto";
			}
			for (var i = 0; i < this.hdrLabels.length; i++) {
				If.appendChild(document.createElement("TH"));
				If.childNodes[i].style.height = "0px";
			}
		}
		this._c_order = null;
		if (this.hu != true) {
			this.obj.className += " row20px";
		}
		this.gB.style.position = "absolute";
		this.gB.style.display = "none";
		this.gB.src = this.eg + "sort_desc.gif";
		this.gB.YR = 0;
		if (this.sB) {
			this.kR.style.display = "none";
		} else {
			this.sB = false;
		}
		if (this.Az) {
			this.FM();
		}
		this.attachHeader();
		this.attachHeader(0, 0, "_aFoot");
		this.setSizes();
		if (fl) {
			this.On();
		}
		this.obj.scrollTop = 0;
		if (this.nz) {
			this.ae.eH(this.aL, this);
		}
		if (this.CV) {
			this.Ve();
		}
		if (this.Yz) {
			this.Yz();
		}
	};
	this.setColumnSizes = function (gridWidth) {
		var AG = 0;
		var HD = [];
		for (var i = 0; i < this.gA; i++) {
			if ((this.initCellWidth[i] == "*") && !this._hrrar[i]) {
				this.Gd = false;
				HD.push(i);
				continue;
			}
			if (this.fL == "%") {
				if (typeof this.cellWidthPC[i] == "undefined") {
					this.cellWidthPC[i] = this.initCellWidth[i];
				}
				this.cellWidthPX[i] = Math.floor(gridWidth * this.cellWidthPC[i] / 100) || 0;
			} else {
				if (typeof this.cellWidthPX[i] == "undefined") {
					this.cellWidthPX[i] = this.initCellWidth[i];
				}
			}
			if (!this._hrrar[i]) {
				AG += this.cellWidthPX[i] * 1;
			}
		}
		if (HD.length) {
			var ms = Math.floor((gridWidth - AG) / HD.length);
			if (ms < 0) {
				ms = 1;
			}
			for (var i = 0; i < HD.length; i++) {
				var next = Math.max((this._drsclmW ? this._drsclmW[HD[i]] : 0), ms);
				this.cellWidthPX[HD[i]] = next;
				AG += next;
			}
			if (gridWidth > AG) {
				var last = HD[HD.length - 1];
				this.cellWidthPX[last] = this.cellWidthPX[last] + (gridWidth - AG);
				AG = gridWidth;
			}
			this.tZ();
		}
		this.obj.style.width = AG + "px";
		this.hdr.style.width = AG + "px";
		if (this.ftr) {
			this.ftr.style.width = AG + "px";
		}
		this.Ue();
		return AG;
	};
	this.setSizes = function () {
		if ((!this.hdr.rows[0])) {
			return;
		}
		var quirks = this.quirks = (_isIE && document.compatMode == "BackCompat");
		var outerBorder = (this.aL.offsetWidth - this.aL.clientWidth) / 2;
		if (this.globalBox) {
			var splitOuterBorder = (this.globalBox.offsetWidth - this.globalBox.clientWidth) / 2;
			if (this._delta_x && !this.nh) {
				var ow = this.globalBox.clientWidth;
				this.globalBox.style.width = this._delta_x;
				this.aL.style.width = Math.max(0, (this.globalBox.clientWidth + (quirks ? splitOuterBorder * 2 : 0)) - this.aC.aL.clientWidth) + "px";
				if (ow != this.globalBox.clientWidth) {
					this.aC.rk(this.aC.aL.clientWidth);
				}
			}
			if (this._delta_y && !this.nh) {
				this.globalBox.style.height = this._delta_y;
				this.aL.style.overflow = this.aC.aL.style.overflow = "hidden";
				this.aL.style.height = this.aC.aL.style.height = this.globalBox.clientHeight + (quirks ? splitOuterBorder * 2 : 0) + "px";
			}
		} else {
			if (this._delta_x) {
				if (this.aL.parentNode.tagName == "TD") {
					this.aL.style.width = "1px";
					this.aL.style.width = parseInt(this._delta_x) * this.aL.parentNode.clientWidth / 100 - outerBorder * 2 + "px";
				} else {
					this.aL.style.width = this._delta_x;
				}
			}
			if (this._delta_y) {
				this.aL.style.height = this._delta_y;
			}
		}
		window.clearTimeout(this.zY);
		if (!this.aL.offsetWidth && (!this.globalBox || !this.globalBox.offsetWidth)) {
			this.zY = window.setTimeout(function () {
				if (self.setSizes) {
					self.setSizes();
				}
			}, 250);
			return;
		}
		var border_x = (((this.aL.arj || this._delta_x) && (this.skin_name || "").indexOf("dhx") == 0 && !quirks) ? 2 : 0);
		var border_y = (((this.aL.arj || this._delta_y) && (this.skin_name || "").indexOf("dhx") == 0 && !quirks) ? 2 : 0);
		var isVScroll = this.parentGrid ? false : (this.HF.scrollHeight > this.HF.offsetHeight);
		var PS = aq ? 18 : 18;
		var gridWidth = this.aL.clientWidth - (this.skin_h_correction || 0) * (quirks ? 0 : 1) - border_x;
		var gridWidthActive = this.aL.clientWidth - (this.skin_h_correction || 0) - border_x;
		var gridHeight = this.aL.clientHeight - border_y;
		var AG = this.setColumnSizes(gridWidthActive - (isVScroll ? PS : 0));
		var isHScroll = this.parentGrid ? false : ((this.HF.scrollWidth > this.HF.offsetWidth) || (this.HF.style.overflowX == "scroll"));
		var headerHeight = this.hdr.clientHeight;
		var footerHeight = this.ftr ? this.ftr.clientHeight : 0;
		var Vc = gridWidth;
		var SQ = gridHeight - headerHeight - footerHeight;
		if (this.Gd && this.Gd[0] && this.Gd[1] == 99999) {
			isHScroll = 0;
		}
		if (this.abK) {
			if (this.aic) {
				SQ = this.aL.parentNode.clientHeight - headerHeight - footerHeight;
			} else {
				SQ = this.obj.offsetHeight + (isHScroll ? PS : 0);
			}
			if (this.FF) {
				if (this.aea) {
					SQ = Math.min(this.FF, SQ + headerHeight + footerHeight) - headerHeight - footerHeight;
				} else {
					SQ = Math.min(this.FF, SQ);
				}
			}
			if (isVScroll && SQ >= this.obj.scrollHeight + (isHScroll ? PS : 0)) {
				isVScroll = false;
				this.setColumnSizes(gridWidthActive);
			}
		}
		if ((this.Gd) && (this.Gd[0])) {
			if (this.fL == "%") {
				this.fL = "px";
			}
			if (this.aC) {
				AG += this.aC.aL.clientWidth;
			}
			var Vc = Math.min(Math.max(AG + (isVScroll ? PS : 0), this.Gd[2]), this.Gd[1]);
			if (this.aC) {
				Vc -= this.aC.aL.clientWidth;
			}
		}
		SQ = Math.max(0, SQ);
		this._ff_size_delta = (this._ff_size_delta == 0.1) ? 0.2 : 0.1;
		if (!aq) {
			this._ff_size_delta = 0;
		}
		this.aL.style.width = Vc + (quirks ? 2 : 0) * outerBorder + this._ff_size_delta + "px";
		this.aL.style.height = SQ + (quirks ? 2 : 0) * outerBorder + headerHeight + footerHeight + "px";
		this.HF.style.height = SQ + ((quirks && !isVScroll) ? 2 : 0) * outerBorder + "px";
		this.kR.style.height = headerHeight + "px";
		if (SQ != gridHeight) {
			this.BD(0, !this.ahK);
		}
		var ext = this["setSizes_" + this.skin_name];
		if (ext) {
			ext.call(this);
		}
		this.vo();
		if (headerHeight != this.hdr.clientHeight && this.abK) {
			this.setSizes();
		}
	};
	this.setSizes_clear = function () {
		var y = this.hdr.offsetHeight;
		var x = this.aL.offsetWidth;
		var y2 = y + this.HF.offsetHeight;
		this.FD.style.top = (y || 0) + "px";
		this.FD.style.width = (x + 20) + "px";
		this.Gc.style.top = (y2 - 3) + "px";
		this.Gc.style.width = (x + 20) + "px";
	};
	this.Ue = function () {
		if ((cU) && (this.ftr)) {
			this.ftr.width = this.HF.scrollWidth + "px";
		}
		var l = this.gA;
		for (var i = 0; i < l; i++) {
			this.hdr.rows[0].cells[i].style.width = this.cellWidthPX[i] + "px";
			this.obj.rows[0].childNodes[i].style.width = this.cellWidthPX[i] + "px";
			if (this.ftr) {
				this.ftr.rows[0].cells[i].style.width = this.cellWidthPX[i] + "px";
			}
		}
	};
	this.alX = function (gX) {
		this.gX = gX;
	};
	this.setInitWidthsP = function (wp) {
		this.fL = "%";
		this.initCellWidth = wp.split(this.gX.replace(/px/gi, ""));
		if (!arguments[1]) {
			this.tZ();
		}
	};
	this.tZ = function () {
		if (this.nh) {
			return;
		}
		var el = window;
		var self = this;
		dhtmlxEvent(window, "resize", function () {
			window.clearTimeout(self.rJ);
			if (self.tZ) {
				self.rJ = window.setTimeout(function () {
					if (self.setSizes) {
						self.setSizes();
					}
					if (self.aC) {
						self.aC.rk();
					}
				}, 100);
			}
		});
	};
	this.setInitWidths = function (wp) {
		this.fL = "px";
		this.initCellWidth = wp.split(this.gX);
		if (aq) {
			for (var i = 0; i < this.initCellWidth.length; i++) {
				if (this.initCellWidth[i] != "*") {
					this.initCellWidth[i] = parseInt(this.initCellWidth[i]);
				}
			}
		}
	};
	this.enableMultiline = function (state) {
		this.hu = ap(state);
	};
	this.enableMultiselect = function (state) {
		this.gN = ap(state);
	};
	this.setImagePath = function (path) {
		this.eg = path;
	};
	this.setImagesPath = this.setImagePath;
	this.setIconPath = function (path) {
		this.iconURL = path;
	};
	this.setIconsPath = this.setIconPath;
	this.bX = function (ev) {
		var el = ev.target || ev.srcElement;
		if (el.tagName != "TD") {
			el = this.bw(el, "TD");
		}
		if (!el) {
			return;
		}
		if ((el.tagName == "TD") && (this.qZ) && (!this.qZ[el._cellIndex])) {
			return el.style.cursor = "default";
		}
		var check = (ev.layerX || 0) + (((!_isIE) && (ev.target.tagName == "DIV")) ? el.offsetLeft : 0);
		if ((el.offsetWidth - (ev.offsetX || (parseInt(this.fI(el, this.kR)) - check) * -1)) < (cU ? 20 : 10)) {
			el.style.cursor = "E-resize";
		} else {
			el.style.cursor = "default";
		}
		if (cU) {
			this.kR.scrollLeft = this.HF.scrollLeft;
		}
	};
	this.eJ = function (ev) {
		if (this.resized) {
			this.fN();
		}
		this.resized = null;
		var el = ev.target || ev.srcElement;
		if (el.tagName != "TD") {
			el = this.bw(el, "TD");
		}
		var x = ev.clientX;
		var afj = this.hdr.offsetWidth;
		var VI = parseInt(el.offsetWidth);
		if (el.tagName == "TD" && el.style.cursor != "default") {
			if ((this.qZ) && (!this.qZ[el._cellIndex])) {
				return;
			}
			self._old_d_mm = document.body.onmousemove;
			self._old_d_mu = document.body.onmouseup;
			document.body.onmousemove = function (e) {
				if (self) {
					self.EO(e || window.event, el, VI, x, afj);
				}
			};
			document.body.onmouseup = function () {
				if (self) {
					self.fN();
				}
			};
		}
	};
	this.fN = function () {
		document.body.onmousemove = self._old_d_mm || "";
		document.body.onmouseup = self._old_d_mu || "";
		this.setSizes();
		this.BD(0, 1);
		this.callEvent("onResizeEnd", [this]);
	};
	this.EO = function (ev, el, VI, x, afj) {
		el.style.cursor = "E-resize";
		this.resized = el;
		var yT = VI + (ev.clientX - x);
		var ash = afj + (ev.clientX - x);
		if (!(this.callEvent("onResize", [el._cellIndex, yT, this]))) {
			return;
		}
		if (_isIE) {
			this.HF.scrollLeft = this.kR.scrollLeft;
		}
		if (el.colSpan > 1) {
			var YZ = new Array();
			for (var i = 0; i < el.colSpan; i++) {
				YZ[i] = Math.round(yT * this.hdr.rows[0].childNodes[el._cellIndexS + i].offsetWidth / el.offsetWidth);
			}
			for (var i = 0; i < el.colSpan; i++) {
				this.si(el._cellIndexS + i * 1, YZ[i]);
			}
		} else {
			this.si(el._cellIndex, yT);
		}
		this.BD(0, 1);
		this.setSizes();
		if (this.aC && this.Gd) {
			this.aC.rk();
		}
	};
	this.si = function (ind, yT) {
		if (yT > ((this._drsclmW && !this.Hc) ? (this._drsclmW[ind] || 10) : 10)) {
			this.obj.rows[0].childNodes[ind].style.width = yT + "px";
			this.hdr.rows[0].childNodes[ind].style.width = yT + "px";
			if (this.ftr) {
				this.ftr.rows[0].childNodes[ind].style.width = yT + "px";
			}
			if (this.fL == "px") {
				this.cellWidthPX[ind] = yT;
			} else {
				var gridWidth = parseInt(this.aL.offsetWidth);
				if (this.HF.scrollHeight > this.HF.offsetHeight) {
					gridWidth -= 17;
				}
				var ais = Math.round(yT / gridWidth * 100);
				this.cellWidthPC[ind] = ais;
			}
			if (this.gB.style.display != "none") {
				this.vo();
			}
		}
	};
	this.co = function (state, ind, order, row) {
		order = (order || "asc").toLowerCase();
		if (!ap(state)) {
			this.gB.style.display = "none";
			this.ij = null;
			return;
		}
		if (order == "asc") {
			this.gB.src = this.eg + "sort_asc.gif";
		} else {
			this.gB.src = this.eg + "sort_desc.gif";
		}
		this.gB.style.display = "";
		this.ij = this.hdr.rows[0].childNodes[ind];
		var r = this.hdr.rows[row || 1];
		if (!r) {
			return;
		}
		for (var i = 0; i < r.childNodes.length; i++) {
			if (r.childNodes[i]._cellIndexS == ind) {
				this.yH = r.childNodes[i];
				return this.vo();
			}
		}
		return this.co(state, ind, order, (row || 1) + 1);
	};
	this.vo = function (ind, mode, aiE, el) {
		if (this._hrrar && this._hrrar[this.yH ? this.yH._cellIndex : ind]) {
			return;
		}
		if (!el) {
			if (!ind) {
				var el = this.yH;
			} else {
				var el = this.hdr.rows[aiE || 0].cells[ind];
			}
		}
		if (el != null) {
			var pos = this.fI(el, this.kR);
			var wdth = el.offsetWidth;
			this.gB.style.left = Number(pos[0] + wdth - 13) + "px";
			this.gB.YR = parseInt(this.gB.style.left);
			this.gB.style.top = Number(pos[1] + 5) + "px";
			if ((!this.pH) && (!mode)) {
				this.gB.style.display = "inline";
			}
			this.gB.style.left = this.gB.YR + "px";
		}
	};
	this.setActive = function (fl) {
		if (arguments.length == 0) {
			var fl = true;
		}
		if (fl == true) {
			if (globalActiveDHTMLGridObject && (globalActiveDHTMLGridObject != this)) {
				globalActiveDHTMLGridObject.editStop();
			}
			globalActiveDHTMLGridObject = this;
			this.ft = true;
		} else {
			this.ft = false;
		}
	};
	this.aV = function (ev) {
		var nt = 0;
		var el = this.bw(_isIE ? ev.srcElement : ev.target, "TD");
		if (!el) {
			return;
		}
		var fl = true;
		if (this.markedCells) {
			var markMethod = 0;
			if (ev.shiftKey || ev.metaKey) {
				markMethod = 1;
			}
			if (ev.ctrlKey) {
				markMethod = 2;
			}
			this.doMark(el, markMethod);
			return true;
		}
		if (this.gN != false) {
			if (ev.shiftKey && this.row != null) {
				nt = 1;
			}
			if (ev.ctrlKey || ev.metaKey) {
				nt = 2;
			}
		}
		this.doClick(el, fl, nt);
	};
	this._doContClick = function (ev) {
		var el = this.bw(_isIE ? ev.srcElement : ev.target, "TD");
		if ((!el) || (typeof (el.parentNode.idd) == "undefined")) {
			return true;
		}
		if (ev.button == 2 || (gP && ev.ctrlKey)) {
			if (!this.callEvent("onRightClick", [el.parentNode.idd, el._cellIndex, ev])) {
				var z = function (e) {
					(e || event).cancelBubble = true;
					return false;
				};
				(ev.srcElement || ev.target).oncontextmenu = z;
				return z(ev);
			}
			if (this.Gs) {
				if (!(this.callEvent("onBeforeContextMenu", [el.parentNode.idd, el._cellIndex, this]))) {
					return true;
				}
				if (_isIE) {
					ev.srcElement.oncontextmenu = function () {
						event.cancelBubble = true;
						return false;
					};
				}
				if (this.Gs.showContextMenu) {
					var aat = window.document.documentElement;
					var aav = window.document.body;
					var Ek = new Array((aat.scrollLeft || aav.scrollLeft), (aat.scrollTop || aav.scrollTop));
					if (_isIE) {
						var x = ev.clientX + Ek[0];
						var y = ev.clientY + Ek[1];
					} else {
						var x = ev.pageX;
						var y = ev.pageY;
					}
					this.Gs.showContextMenu(x - 1, y - 1);
					this.contextID = this.Gs.contextMenuZoneId = el.parentNode.idd + "_" + el._cellIndex;
					this.Gs._skip_hide = true;
				} else {
					el.contextMenuId = el.parentNode.idd + "_" + el._cellIndex;
					el.contextMenu = this.Gs;
					el.a = this.Gs.vm;
					el.a(el, ev);
					el.a = null;
				}
				ev.cancelBubble = true;
				return false;
			}
		} else {
			if (this.Gs) {
				if (this.Gs.hideContextMenu) {
					this.Gs.hideContextMenu();
				} else {
					this.Gs.ES();
				}
			}
		}
		return true;
	};
	this.doClick = function (el, fl, nt, show, doch) {
		if (!this.gN) {
			nt = 0;
		} else {
			var hasCB = false;
			var cbIdx;
			for (var ct_idx = 0; ct_idx < this.cellType.length; ct_idx++){
				if(this.cellType[ct_idx] == "ch") {
					cbIdx = ct_idx;
					hasCB = true;
					break;
				}
			}
			
			if(hasCB) {
				if(doch) {
					//var row_idx = this.am.bP(el.parentNode);
					//var r = this.dz(row_idx+1);
					//var el_ch = r.childNodes[cbIdx];
					//var ex = new eXcell_ch(el_ch);
					//ex.changeState();
				} else {
					return;
				}
			}
		}
		var alh = this.row ? this.row.idd : 0;
		this.setActive(true);
		if (!nt) {
			nt = 0;
		}
		
		if (this.cell != null) {
			this.cell.className = this.cell.className.replace(/cellselected/g, "");
		}
		if (el.tagName == "TD") {
			if (this.mR("onSelectStateChanged")) {
				var ajG = this.bI();
			}
			var GZ = this.row;
			if (nt == 1) {
				var GN = this.am.bP(el.parentNode);
				var Hm = this.am.bP(this.Ms);
				if (GN > Hm) {
					var akL = Hm;
					var end = GN;
				} else {
					var akL = GN;
					var end = Hm;
				}
				for (var i = 0; i < this.am.length; i++) {
					if ((i >= akL && i <= end)) {
						if (this.am[i] && (!this.am[i].kp)) {
							if (this.am[i].className.indexOf("rowselected") == -1 && this.callEvent("onBeforeSelect", [this.am[i].idd, alh])) {
								this.am[i].className += " rowselected";
								this.bY[this.bY.length] = this.am[i];
							}
						} else {
							this.pL();
							return this.doClick(el, fl, 0, show);
						}
					}
				}
			} else {
				if (nt == 2) {
					if (el.parentNode.className.indexOf("rowselected") != -1) {
						el.parentNode.className = el.parentNode.className.replace(/rowselected/g, "");
						this.bY.hd(this.bY.bP(el.parentNode));
						var Nt = true;
					}
				}
			}
			this.editStop();
			if (typeof (el.parentNode.idd) == "undefined") {
				return true;
			}
			if ((!Nt) && (!el.parentNode.kp)) {
				if (this.callEvent("onBeforeSelect", [el.parentNode.idd, alh])) {
					if (nt == 0) {
						this.pL();
					}
					this.cell = el;
					if ((GZ == el.parentNode) && (this.adC)) {
						fl = false;
					}
					this.row = el.parentNode;
					this.row.className += " rowselected";
					if (this.cell && _isIE && _isIE == 8) {
						var next = this.cell.nextSibling;
						var parent = this.cell.parentNode;
						parent.removeChild(this.cell);
						parent.insertBefore(this.cell, next);
					}
					if (this.bY.bP(this.row) == -1) {
						this.bY[this.bY.length] = this.row;
					}
				} else {
					fl = false;
				}
			}
			if (this.cell && this.cell.parentNode.className.indexOf("rowselected") != -1) {
				this.cell.className = this.cell.className.replace(/cellselected/g, "") + " cellselected";
			}
			if (nt != 1) {
				if (!this.row) {
					return;
				}
			}
			this.Ms = el.parentNode;
			var Mj = this.row.idd;
			var arX = this.cell;
			if (fl && typeof (Mj) != "undefined" && arX && !Nt) {
				self.Ti = setTimeout(function () {
					self.callEvent("onRowSelect", [Mj, arX._cellIndex]);
				}, 100);
			}
			if (this.mR("onSelectStateChanged")) {
				var adV = this.bI();
				if (ajG != adV) {
					this.callEvent("onSelectStateChanged", [adV, ajG]);
				}
			}
		}
		this.ft = true;
		if (show !== false && this.cell && this.cell.parentNode.idd) {
			this.HZ(this.cell);
		}
	};
	this.adx = function () {
		this.pL();
		var coll = this.aD;
		if (this.aW) {
			coll = this.am;
		}
		for (var i = 0; i < coll.length; i++) {
			this.render_row(i).className += " rowselected";
		}
		this.bY = dhtmlxArray([].concat(coll));
		if (this.bY.length) {
			this.row = this.bY[0];
			this.cell = this.row.cells[0];
		}
		if ((this.aC) && (!this.nh)) {
			this.aC.adx();
		}
	};
	this.eQ = function (r, vF, fl, iW, edit, show) {
		if (!fl) {
			fl = false;
		}
		if (typeof (r) != "object") {
			r = this.render_row(r);
		}
		if (!r || r == -1) {
			return null;
		}
		if (r.bq) {
			var c = r.childNodes[r.bq[vF]];
		} else {
			var c = r.childNodes[vF];
		}
		if (!c) {
			c = r.childNodes[0];
		}
		if (iW) {
			this.doClick(c, fl, 3, show);
		} else {
			this.doClick(c, fl, 0, show);
		}
		if (edit) {
			this.gh();
		}
	};
	this.HZ = function (Tn, aaS) {
		if (this.aW) {
			var newPage = Math.floor(this.getRowIndex(Tn.parentNode.idd) / this.cu) + 1;
			if (newPage != this.ew) {
				this.changePage(newPage);
			}
		}
		if (!Tn.offsetHeight && this.ahK) {
			var mask = this.nh ? this.aC.bj[Tn.parentNode.idd] : Tn.parentNode;
			var h = this.aD.bP(mask) * this.ig;
			return this.HF.scrollTop = h;
		}
		try {
			var BZ = Tn.offsetLeft + Tn.offsetWidth + 20;
			var scrollLeft = 0;
			if (BZ > (this.HF.offsetWidth + this.HF.scrollLeft)) {
				if (Tn.offsetLeft > this.HF.scrollLeft) {
					scrollLeft = Tn.offsetLeft - 5;
				}
			} else {
				if (Tn.offsetLeft < this.HF.scrollLeft) {
					BZ -= Tn.offsetWidth * 2 / 3;
					if (BZ < this.HF.scrollLeft) {
						scrollLeft = Tn.offsetLeft - 5;
					}
				}
			}
			if ((scrollLeft) && (!aaS)) {
				this.HF.scrollLeft = scrollLeft;
			}
			var BZ = Tn.offsetTop + Tn.offsetHeight + 20;
			if (BZ > (this.HF.offsetHeight + this.HF.scrollTop)) {
				var scrollTop = BZ - this.HF.offsetHeight;
			} else {
				if (Tn.offsetTop < this.HF.scrollTop) {
					var scrollTop = Tn.offsetTop - 5;
				}
			}
			if (scrollTop) {
				this.HF.scrollTop = scrollTop;
			}
		}
		catch (er) {
		}
	};
	this.gh = function () {
		if (this.editor && this.cell == this.editor.cell) {
			return;
		}
		this.editStop();
		if ((this.isEditable != true) || (!this.cell)) {
			return false;
		}
		var c = this.cell;
		if (c.parentNode.FG) {
			return false;
		}
		this.editor = this.cells4(c);
		if (this.editor != null) {
			if (this.editor.isDisabled()) {
				this.editor = null;
				return false;
			}
			if (this.callEvent("onEditCell", [0, this.row.idd, this.cell._cellIndex]) != false && this.editor.edit) {
				this.EH = (new Date).valueOf();
				c.className += " editable";
				this.editor.edit();
				this.callEvent("onEditCell", [1, this.row.idd, this.cell._cellIndex]);
			} else {
				this.editor = null;
			}
		}
	};
	this.editStop = function (mode) {
		if (cU) {
			if (this.EH) {
				if ((this.EH * 1 + 50) > (new Date).valueOf()) {
					return;
				}
				this.EH = null;
			}
		}
		if (this.editor && this.editor != null) {
			this.editor.cell.className = this.editor.cell.className.replace("editable", "");
			if (mode) {
				var t = this.editor.val;
				this.editor.detach();
				this.editor.setValue(t);
				this.editor = null;
				return;
			}
			if (this.editor.detach()) {
				this.cell.hy = true;
			}
			var g = this.editor;
			this.editor = null;
			var z = this.callEvent("onEditCell", [2, this.row.idd, this.cell._cellIndex, g.getValue(), g.val]);
			if ((typeof (z) == "string") || (typeof (z) == "number")) {
				g[g.hW ? "setLabel" : "setValue"](z);
			} else {
				if (!z) {
					g[g.hW ? "setLabel" : "setValue"](g.val);
				}
			}
			if (this.abK && this.hu) {
				this.setSizes();
			}
		}
	};
	this.Yc = function (row, dir, pos) {
		row = this.CE((this.pj ? this.am : this.aD).bP(row), dir);
		if (!row) {
			return null;
		}
		return row.childNodes[row.bq ? row.bq[pos] : pos];
	};
	this.Kn = function (mK, dir, i) {
		mK = mK || this.cell;
		var nU = mK.parentNode;
		if (this.Wq) {
			i = this.Wq[mK._cellIndex];
			if (typeof i != "undefined") {
				if (i < 0) {
					mK = this.Yc(nU, dir, Math.abs(i) - 1);
				} else {
					mK = nU.childNodes[i];
				}
			}
		} else {
			var i = mK._cellIndex + dir;
			if (i >= 0 && i < this.gA) {
				if (nU.bq) {
					i = nU.bq[mK._cellIndex] + dir;
				}
				mK = nU.childNodes[i];
			} else {
				mK = this.Yc(nU, dir, (dir == 1 ? 0 : (this.gA - 1)));
			}
		}
		if (!mK) {
			if ((dir == 1) && this.tabEnd) {
				this.tabEnd.focus();
				this.tabEnd.focus();
				this.setActive(false);
			}
			if ((dir == -1) && this.tabStart) {
				this.tabStart.focus();
				this.tabStart.focus();
				this.setActive(false);
			}
			return null;
		}
		if (mK.style.display != "none" && (!this.smartTabOrder || !this.cells(mK.parentNode.idd, mK._cellIndex).isDisabled())) {
			return mK;
		}
		return this.Kn(mK, dir);
	};
	this.CE = function (ind, dir) {
		var r = this.render_row(ind + dir);
		if (!r || r == -1) {
			return null;
		}
		if (r && r.style.display == "none") {
			return this.CE(ind + dir, dir);
		}
		return r;
	};
	this.PP = function (dir) {
		if (!this.aD.length) {
			return;
		}
		var master = this.nh ? this.aC : this;
		var wc = Math.floor((master._r_select || this.getRowIndex(this.row.idd) || 0) + (dir) * this.HF.offsetHeight / (this.ig || 20));
		if (wc < 0) {
			wc = 0;
		}
		if (wc >= this.aD.length) {
			wc = this.aD.length - 1;
		}
		if (this.ahK && !this.aD[wc]) {
			this.HF.scrollTop += Math.floor((dir) * this.HF.offsetHeight / (this.ig || 20)) * (this.ig || 20);
			master._r_select = wc;
		} else {
			this.eQ(wc, this.cell._cellIndex, true, false, false, (this.hu || this.ahK));
			if (!this.hu && !this.ahK && !this.nh) {
				this.HF.scrollTop = this.dz(this.bB(wc)).offsetTop;
			}
			master._r_select = null;
		}
	};
	this.bQ = function (ev) {
		if (!ev) {
			return true;
		}
		if ((ev.target || ev.srcElement).value !== window.undefined) {
			var zx = (ev.target || ev.srcElement);
			if ((!zx.parentNode) || (zx.parentNode.className.indexOf("editable") == -1)) {
				return true;
			}
		}
		if ((globalActiveDHTMLGridObject) && (this != globalActiveDHTMLGridObject)) {
			return globalActiveDHTMLGridObject.bQ(ev);
		}
		if (this.ft == false) {
			return true;
		}
		if (this.Zl) {
			return true;
		}
		if (!this.callEvent("onKeyPress", [ev.keyCode, ev.ctrlKey, ev.shiftKey, ev])) {
			return false;
		}
		var code = "k" + ev.keyCode + "_" + (ev.ctrlKey ? 1 : 0) + "_" + (ev.shiftKey ? 1 : 0);
		if (this.cell) {
			if (this.zf[code]) {
				if (false === this.zf[code].call(this)) {
					return true;
				}
				if (ev.preventDefault) {
					ev.preventDefault();
				}
				ev.cancelBubble = true;
				return false;
			}
			if (this.zf["k_other"]) {
				this.zf.k_other.call(this, ev);
			}
		}
		return true;
	};
	this.Th = function (r, fl, iW, show) {
		if (typeof (r) != "object") {
			r = this.render_row(r);
		}
		this.eQ(r, 0, fl, iW, false, show);
	};
	this.gF = function (ev) {
		var el = this.bw(_isIE ? ev.srcElement : ev.target, "TD");
		if (el) {
			var cq = el.parentNode.idd;
			return this.callEvent("onRowDblClicked", [cq, el._cellIndex]);
		}
	};
	this.FJ = function (e, el) {
		var that = this.grid;
		el = el || that.bw(_isIE ? event.srcElement : e.target, "TD");
		if (this.grid.resized == null) {
			if (!(this.grid.callEvent("onHeaderClick", [el._cellIndexS, (e || window.event)]))) {
				return false;
			}
			that.adU(el._cellIndexS, false, el);
		}
	};
	this.Yb = function () {
		var num = this.bY.length;
		if (num == 0) {
			return;
		}
		var anb = this.bY;
		this.bY = dhtmlxArray();
		for (var i = num - 1; i >= 0; i--) {
			var node = anb[i];
			if (!this.deleteRow(node.idd, node)) {
				this.bY[this.bY.length] = node;
			} else {
				if (node == this.row) {
					var ind = i;
				}
			}
		}
		if (ind) {
			try {
				if (ind + 1 > this.am.length) {
					ind--;
				}
				this.eQ(ind, 0, true);
			}
			catch (er) {
				this.row = null;
				this.cell = null;
			}
		}
	};
	this.acg = function () {
		var UC = new Array(0);
		var aov = {};
		for (var i = 0; i < this.bY.length; i++) {
			var id = this.bY[i].idd;
			if (aov[id]) {
				continue;
			}
			UC[UC.length] = id;
			aov[id] = true;
		}
		if (UC.length == 0) {
			return null;
		} else {
			return UC.join(this.gX);
		}
	};
	this.iL = function () {
		if (this.cell != null) {
			return this.cell._cellIndex;
		} else {
			return -1;
		}
	};
	this.yI = function (ind) {
		return parseInt(this.cellWidthPX[ind]) + ((aq) ? 2 : 0);
	};
	this.setColWidth = function (ind, value) {
		if (this._hrrar[ind]) {
			return;
		}
		if (this.fL == "px") {
			this.cellWidthPX[ind] = parseInt(value) - +((aq) ? 2 : 0);
		} else {
			this.cellWidthPC[ind] = parseInt(value);
		}
		this.setSizes();
	};
	this.getRowIndex = function (bO) {
		for (var i = 0; i < this.aD.length; i++) {
			if (this.aD[i] && this.aD[i].idd == bO) {
				return i;
			}
		}
		return -1;
	};
	this.bB = function (ind) {
		return this.aD[ind] ? this.aD[ind].idd : this.undefined;
	};
	this.agA = function (ind, bO) {
		this.changeRowId(this.bB(ind), bO);
	};
	this.changeRowId = function (qX, vu) {
		if (qX == vu) {
			return;
		}
		var row = this.bj[qX];
		row.idd = vu;
		if (this.bH[qX]) {
			this.bH[vu] = this.bH[qX];
			this.bH[qX] = null;
		}
		if (this._h2 && this._h2.get[qX]) {
			this._h2.get[vu] = this._h2.get[qX];
			this._h2.get[vu].id = vu;
			delete this._h2.get[qX];
		}
		this.bj[qX] = null;
		this.bj[vu] = row;
		for (var i = 0; i < row.childNodes.length; i++) {
			if (row.childNodes[i].Lq) {
				row.childNodes[i].Lq = this.MB(row.childNodes[i].AB, row.childNodes[i]);
			}
		}
		if (this._mat_links && this._mat_links[qX]) {
			var a = this._mat_links[qX];
			delete this._mat_links[qX];
			for (var c in a) {
				for (var i = 0; i < a[c].length; i++) {
					this.MB(a[c][i].eN, a[c][i]);
				}
			}
		}
		this.callEvent("onRowIdChange", [qX, vu]);
	};
	this.setColumnIds = function (ids) {
		this.columnIds = ids.split(this.gX);
	};
	this.amG = function (ind, id) {
		this.columnIds[ind] = id;
	};
	this.getColIndexById = function (id) {
		for (var i = 0; i < this.columnIds.length; i++) {
			if (this.columnIds[i] == id) {
				return i;
			}
		}
	};
	this.getColumnId = function (agY) {
		return this.columnIds[agY];
	};
	this.adE = function (agY, ind, hdr) {
		var z = (hdr || this.hdr).rows[(ind || 0) + 1];
		for (var i = 0; i < z.cells.length; i++) {
			if (z.cells[i]._cellIndexS == agY) {
				return (_isIE ? z.cells[i].innerText : z.cells[i].textContent);
			}
		}
		return "";
	};
	this.getColLabel = this.adE;
	this.getFooterLabel = function (agY, ind) {
		return this.adE(agY, ind, this.ftr);
	};
	this.tG = function (bO) {
		var r = this.dz(bO);
		if (r) {
			r.style.fontWeight = "bold";
		}
	};
	this.setRowTextStyle = function (bO, jp) {
		var r = this.dz(bO);
		if (!r) {
			return;
		}
		for (var i = 0; i < r.childNodes.length; i++) {
			var yb = r.childNodes[i]._attrs["style"] || "";
			if ((this._hrrar) && (this._hrrar[i])) {
				yb = "display:none;";
			}
			if (_isIE) {
				r.childNodes[i].style.cssText = yb + "width:" + r.childNodes[i].style.width + ";" + jp;
			} else {
				r.childNodes[i].style.cssText = yb + "width:" + r.childNodes[i].style.width + ";" + jp;
			}
		}
	};
	this.EA = function (bO, color) {
		var r = this.dz(bO);
		for (var i = 0; i < r.childNodes.length; i++) {
			r.childNodes[i].bgColor = color;
		}
	};
	this.setCellTextStyle = function (bO, ind, jp) {
		var r = this.dz(bO);
		if (!r) {
			return;
		}
		var cell = r.childNodes[r.bq ? r.bq[ind] : ind];
		if (!cell) {
			return;
		}
		var yb = "";
		if ((this._hrrar) && (this._hrrar[ind])) {
			yb = "display:none;";
		}
		if (_isIE) {
			cell.style.cssText = yb + "width:" + cell.style.width + ";" + jp;
		} else {
			cell.style.cssText = yb + "width:" + cell.style.width + ";" + jp;
		}
	};
	this.rn = function (bO) {
		var r = this.dz(bO);
		if (r) {
			r.style.fontWeight = "normal";
		}
	};
	this.aai = function (bO) {
		if (this.dz(bO) != null) {
			return true;
		} else {
			return false;
		}
	};
	this.adG = function () {
		return this.gA;
	};
	this.zs = function (bO) {
		var r = this.dz(bO);
		if (this.gY()) {
			return this.MN(bO, -1);
		}
		var RM = this.am.bP(r);
		if ((r.previousSibling) && (RM != 0)) {
			r.parentNode.insertBefore(r, r.previousSibling);
			this.am.yk(RM, RM - 1);
			this.setSizes();
			var bInd = this.aD.bP(r);
			this.aD.yk(bInd, bInd - 1);
			if (this.hC) {
				this._fixAlterCss(RM - 1);
			}
		}
	};
	this.uQ = function (bO) {
		var r = this.dz(bO);
		if (this.gY()) {
			return this.MN(bO, 1);
		}
		var RM = this.am.bP(r);
		if (r.nextSibling) {
			this.am.yk(RM, RM + 1);
			if (r.nextSibling.nextSibling) {
				r.parentNode.insertBefore(r, r.nextSibling.nextSibling);
			} else {
				r.parentNode.appendChild(r);
			}
			this.setSizes();
			var bInd = this.aD.bP(r);
			this.aD.yk(bInd, bInd + 1);
			if (this.hC) {
				this._fixAlterCss(RM);
			}
		}
	};
	this.cf = function (mf) {
		if (!this.combos[mf]) {
			this.combos[mf] = new dhtmlXGridComboObject();
		}
		return this.combos[mf];
	};
	this.setUserData = function (bO, name, value) {
		if (!bO) {
			bO = "gridglobaluserdata";
		}
		if (!this.bH[bO]) {
			this.bH[bO] = new qB();
		}
		this.bH[bO].eT(name, value);
	};
	this.getUserData = function (bO, name) {
		if (!bO) {
			bO = "gridglobaluserdata";
		}
		this.dz(bO);
		var z = this.bH[bO];
		return (z ? z.get(name) : "");
	};
	this.setEditable = function (fl) {
		this.isEditable = ap(fl);
	};
	this.selectRowById = function (bO, ajh, show, call) {
		if (!call) {
			call = false;
		}
		this.eQ(this.dz(bO), 0, call, ajh, false, show);
	};
	this.pL = function () {
		this.editStop();
		for (var i = 0; i < this.bY.length; i++) {
			var r = this.bj[this.bY[i].idd];
			if (r) {
				r.className = r.className.replace(/rowselected/g, "");
			}
		}
		this.bY = dhtmlxArray();
		this.row = null;
		if (this.cell != null) {
			this.cell.className = this.cell.className.replace(/cellselected/g, "");
			this.cell = null;
		}
	};
	this.RK = function (from_row_id, zH) {
		var QC = this.dz(from_row_id);
		if (!this.gY()) {
			for (var i = 0; i < QC.cells.length; i++) {
				this.cells(zH, i).setValue(this.cells(from_row_id, i).getValue());
			}
		} else {
			this.DF(QC, from_row_id, zH);
		}
		if (!_isIE) {
			this.dz(from_row_id).cells[0].height = QC.cells[0].offsetHeight;
		}
	};
	this.setFooterLabel = function (c, label, ind) {
		return this.adA(c, label, ind, this.ftr);
	};
	this.adA = function (c, label, ind, hdr) {
		var z = (hdr || this.hdr).rows[ind || 1];
		var col = (z.bq ? z.bq[c] : c);
		if (!z.cells[col]) {
			return;
		}
		if (!this.pH) {
			var ep = "<div class='hdrcell'>";
			if (label.indexOf("img:[") != -1) {
				var anc = label.replace(/.*\[([^>]+)\].*/, "$1");
				label = label.substr(label.indexOf("]") + 1, label.length);
				ep += "<img width='18px' height='18px' align='absmiddle' src='" + anc + "' hspace='2'>";
			}
			ep += label;
			ep += "</div>";
			z.cells[col].innerHTML = ep;
			if (this.Oi[col]) {
				z.cells[col].style.cssText = this.Oi[col];
			}
		} else {
			z.cells[col].style.textAlign = "left";
			z.cells[col].innerHTML = "<img src='" + this.eg + "" + label + "' onerror='this.src = \"" + this.eg + "imageloaderror.gif\"'>";
			var a = new Image();
			a.src = this.eg + "" + label.replace(/(\.[a-z]+)/, ".des$1");
			this.sf[this.sf.length] = a;
			var b = new Image();
			b.src = this.eg + "" + label.replace(/(\.[a-z]+)/, ".asc$1");
			this.sf[this.sf.length] = b;
		}
		if ((label || "").indexOf("#") != -1) {
			var t = label.match(/(^|{)#([^}]+)(}|$)/);
			if (t) {
				var tn = "_in_header_" + t[2];
				if (this[tn]) {
					this[tn]((this.qW ? z.cells[col].firstChild : z.cells[col]), col, label.split(t[0]));
				}
			}
		}
	};
	this.setColLabel = function (a, b, ind, c) {
		return this.adA(a, b, (ind || 0) + 1, c);
	};
	this.clearAll = function (header) {
		if (!this.obj.rows[0]) {
			return;
		}
		if (this._h2) {
			this._h2 = new dhtmlxHierarchy();
			if (this.aC) {
				if (this.nh) {
					this._h2 = this.aC._h2;
				} else {
					this.aC._h2 = this._h2;
				}
			}
		}
		this.limit = this.LC = 0;
		this.editStop(true);
		if (this.ee) {
			window.clearTimeout(this.ee);
		}
		if (this.ic) {
			this.HF.scrollTop = 0;
			this.limit = this.LC || 0;
			this.CV = true;
		}
		var len = this.am.length;
		len = this.obj.rows.length;
		for (var i = len - 1; i > 0; i--) {
			var acY = this.obj.rows[i];
			acY.parentNode.removeChild(acY);
		}
		if (header) {
			this._master_row = null;
			this.obj.rows[0].parentNode.removeChild(this.obj.rows[0]);
			for (var i = this.hdr.rows.length - 1; i >= 0; i--) {
				var acY = this.hdr.rows[i];
				acY.parentNode.removeChild(acY);
			}
			if (this.ftr) {
				this.ftr.parentNode.removeChild(this.ftr);
				this.ftr = null;
			}
			this._aHead = this.ftr = this.aoX = this._aFoot = null;
			this.cellType = dhtmlxArray();
			this._hrrar = [];
			this.columnIds = [];
			this.combos = [];
		}
		this.row = null;
		this.cell = null;
		this.am = dhtmlxArray();
		this.bj = [];
		this.afF = [];
		this.aD = dhtmlxArray();
		this.bH = [];
		this.bY = dhtmlxArray();
		if (this.aW || this.ahK) {
			this.tR = "";
		}
		if (this.aW) {
			this.changePage(1);
		}
		if (this.Bf) {
			window.clearTimeout(this.Bf);
		}
		if (this.agg) {
			this.enableStableSorting(true);
		}
		this._fillers = this.undefined;
		this.co(false);
		this.setSizes();
		this.callEvent("onClearAll", []);
	};
	this.adU = function (ind, Vj, afe) {
		if (this.iD() == 0) {
			return false;
		}
		var el = this.hdr.rows[0].cells[ind];
		if (!el) {
			return;
		}
		if (el.tagName == "TH" && (this.fldSort.length - 1) >= el._cellIndex && this.fldSort[el._cellIndex] != "na") {
			var data = this.xu();
			var HL = (data[0] == ind && data[1] == "asc") ? "des" : "asc";
			if (!this.callEvent("onBeforeSorting", [ind, this.fldSort[ind], HL])) {
				return;
			}
			this.gB.src = this.eg + "sort_" + (HL == "asc" ? "asc" : "desc") + ".gif";
			if (this.pH) {
				var ahk = this.hdr.rows[1].cells[el._cellIndex].firstChild;
				if (this.ij != null) {
					var akm = this.hdr.rows[1].cells[this.ij._cellIndex].firstChild;
					akm.src = akm.src.replace(/(\.asc\.)|(\.des\.)/, ".");
				}
				ahk.src = ahk.src.replace(/(\.[a-z]+)$/, "." + HL + "$1");
			}
			this.xK(el._cellIndex, this.fldSort[el._cellIndex], HL);
			this.ij = el;
			this.yH = afe;
			var c = this.hdr.rows[1];
			var c = afe.parentNode;
			var aqB = c.bq ? c.bq[el._cellIndex] : el._cellIndex;
			this.vo(false, false, false, afe);
		}
	};
	this.setCustomSorting = function (aQ, col) {
		if (!this._customSorts) {
			this._customSorts = new Array();
		}
		this._customSorts[col] = (typeof (aQ) == "string") ? eval(aQ) : aQ;
		this.fldSort[col] = "cus";
	};
	this.enableHeaderImages = function (fl) {
		this.pH = fl;
	};
	this.setHeader = function (Vb, JP, akR) {
		if (typeof (Vb) != "object") {
			var UK = this.ZK(Vb);
		} else {
			UK = [].concat(Vb);
		}
		var VW = new Array(0);
		var abA = new dhtmlxArray(0);
		var aaI = new Array(0);
		var Xr = new Array(0);
		var abx = new Array(0);
		for (var i = 0; i < UK.length; i++) {
			VW[VW.length] = Math.round(100 / UK.length);
			abA[abA.length] = "ed";
			aaI[aaI.length] = "left";
			Xr[Xr.length] = "middle";
			abx[abx.length] = "na";
		}
		this.JP = JP || "#cspan";
		this.hdrLabels = UK;
		this.aoX = VW;
		if (!this.initCellWidth.length) {
			this.setInitWidthsP(VW.join(this.gX), true);
		}
		this.cellType = abA;
		this.cellAlign = aaI;
		this.cellVAlign = Xr;
		this.fldSort = abx;
		this.Oi = akR || [];
	};
	this.ZK = function (str) {
		//if (![].push) {
//			return str.split(this.gX);
//		}
//		var a = "r" + (new Date()).valueOf();
//		var z = this.gX.replace(/([\|\+\*\^])/g, "\\$1");
//		return (str || "").replace(RegExp(z, "g"), a).replace(RegExp("\\\\" + a, "g"), this.gX).split(a);
 var rtn;
        var replaceMap = new Array();
        i = 0;

        var testStr = str.replace(/\s{2,}/g, "");

        while((idx = testStr.indexOf("<")) != -1) {
            idx1 = testStr.indexOf(" ", idx);
            if (idx1 != -1){
                tag = testStr.substring(idx+1, idx1);
                idx2 = testStr.indexOf("/"+tag, idx1);
                if (idx2 != -1) {
                    idx3 = testStr.indexOf(">", idx2);
                    if (idx3 != -1){
                        aStr = testStr.substring(idx, idx3+1);
                        testStr = testStr.replace(aStr, "tempCol_def"+i);
                        replaceMap[i] = new Array();
                        replaceMap[i][0] = "tempCol_def"+i;
                        replaceMap[i][1] = aStr;
                    }
                }
            }
            i++;
        }
        if (![].push)
            rtn = testStr.split(this.delim);

        var a = "r"+(new Date()).valueOf();
        var z = this.gX.replace(/([\|\+\*\^])/g, "\\$1")
        rtn = (testStr||"").replace(RegExp(z, "g"), a).replace(RegExp("\\\\"+a, "g"), this.delim).split(a);
        for(i=0;i<rtn.length;i++){
            for(j=0;j<replaceMap.length;j++){
                if (rtn[i].indexOf(replaceMap[j][0])!= -1){
                    rtn[i] = (rtn[i]||"").replace(replaceMap[j][0], replaceMap[j][1]);
                }
          }
        }
        return rtn;
	};
	this.abv = function (vF) {
		return this.cellType[vF];
	};
	this.aii = function (cID) {
		return this.cellType[this.getColIndexById(cID)];
	};
	this.setColTypes = function (ajo) {
		this.cellType = dhtmlxArray(ajo.split(this.gX));
		this.dA = new Array();
		for (var i = 0; i < this.cellType.length; i++) {
			if ((this.cellType[i].indexOf("[") != -1)) {
				var z = this.cellType[i].split(/[\[\]]+/g);
				this.cellType[i] = z[0];
				this.QL[i] = z[1];
				if (z[1].indexOf("=") == 0) {
					this.cellType[i] = "math";
					this.dA[i] = z[0];
				}
			}
			if (!window["eXcell_" + this.cellType[i]]) {
				dhtmlxError.gn("Configuration", "Incorrect cell type: " + this.cellType[i], [this, this.cellType[i]]);
			}
		}
	};
	this.setColSorting = function (aiD) {
		this.fldSort = aiD.split(this.gX);
		for (var i = 0; i < this.fldSort.length; i++) {
			if (((this.fldSort[i]).length > 4) && (typeof (window[this.fldSort[i]]) == "function")) {
				if (!this._customSorts) {
					this._customSorts = new Array();
				}
				this._customSorts[i] = window[this.fldSort[i]];
				this.fldSort[i] = "cus";
			}
		}
	};
	this.setColAlign = function (ZL) {
		this.cellAlign = ZL.split(this.gX);
		for (var i = 0; i < this.cellAlign.length; i++) {
			this.cellAlign[i] = this.cellAlign[i].PA();
		}
	};
	this.setColVAlign = function (valStr) {
		this.cellVAlign = valStr.split(this.gX);
	};
	this.setNoHeader = function (fl) {
		this.sB = ap(fl);
	};
	this.aqG = function (UD) {
		this.dz(UD);
		if (this._h2) {
			this.hx(this._h2.get[UD].parent.id);
		}
		var c = this.dz(UD).childNodes[0];
		while (c && c.style.display == "none") {
			c = c.nextSibling;
		}
		if (c) {
			this.HZ(c, true);
		}
	};
	this.mp = function (aeu, aiL, fZ, aet) {
		this.Gz = [aeu, aiL, fZ, fZ, aet];
		var ZR = ["#" + this.aL.id + " table.hdr td", "#" + this.aL.id + " table.obj td", "#" + this.aL.id + " table.obj tr.rowselected td.cellselected", "#" + this.aL.id + " table.obj td.cellselected", "#" + this.aL.id + " table.obj tr.rowselected td"];
		for (var i = 0; i < ZR.length; i++) {
			if (this.Gz[i]) {
				if (_isIE) {
					document.styleSheets[0].addRule(ZR[i], this.Gz[i]);
				} else {
					document.styleSheets[0].insertRule(ZR[i] + (" {" + this.Gz[i] + " }"), document.styleSheets[0].cssRules.length);
				}
			}
		}
	};
	this.setColumnColor = function (arp) {
		this.columnColor = arp.split(this.gX);
	};
	this.enableAlterCss = function (alF, alH, aeU, Yf) {
		if (alF || alH) {
			this.attachEvent("onGridReconstructed", function () {
				this._fixAlterCss();
				if (this.aC) {
					this.aC._fixAlterCss();
				}
			});
		}
		this.Cw = aeU;
		this.Vh = Yf;
		this.hC = alF;
		this.iI = alH;
	};
	this._fixAlterCss = function (ind) {
		if (this._h2 && (this.Cw || this.Vh)) {
			return this.ahx(ind);
		}
		if (!this.hC && !this.iI) {
			return;
		}
		ind = ind || 0;
		var j = ind;
		for (var i = ind; i < this.am.length; i++) {
			if (!this.am[i]) {
				continue;
			}
			if (this.am[i].style.display != "none") {
				if (this.am[i].te) {
					j = 1;
					continue;
				}
				if (this.am[i].className.indexOf("rowselected") != -1) {
					if (j % 2 == 1) {
						this.am[i].className = this.iI + " rowselected " + (this.am[i].Vn || "");
					} else {
						this.am[i].className = this.hC + " rowselected " + (this.am[i].Vn || "");
					}
				} else {
					if (j % 2 == 1) {
						this.am[i].className = this.iI + " " + (this.am[i].Vn || "");
					} else {
						this.am[i].className = this.hC + " " + (this.am[i].Vn || "");
					}
				}
				j++;
			}
		}
	};
	this.KQ = function () {
		for (var i = 0; i < this.am.length; i++) {
			var row = this.am[i];
			var cols = row.childNodes.length;
			for (var j = 0; j < cols; j++) {
				row.childNodes[j].hy = false;
			}
		}
	};
	this.Dk = function (and_added) {
		var res = new Array();
		this.forEachRow(function (id) {
			var row = this.bj[id];
			if (row.tagName != "TR") {
				return;
			}
			var cols = row.childNodes.length;
			if (and_added && row.adM) {
				res[res.length] = row.idd;
			} else {
				for (var j = 0; j < cols; j++) {
					if (row.childNodes[j].hy) {
						res[res.length] = row.idd;
						break;
					}
				}
			}
		});
		return res.join(this.gX);
	};
	this.Jb = false;
	this.Jr = false;
	this.fu = function (userData, QT, config, GM, GA, MZ) {
		this.Jb = userData;
		this.Jr = QT;
		this.Ld = config;
		this.Zx = GM;
		this.xq = GA;
		this.LB = MZ;
	};
	this.pm = function (list) {
		if (!list) {
			this.nF = null;
			return;
		}
		this.nF = (list || "").split(",");
		for (var i = 0; i < this.nF.length; i++) {
			this.nF[i] = ap(this.nF[i]);
		}
	};
	this.JS = function (Nv, inner, closed) {
		this.editStop();
		var out = [];
		var close = "</" + this.xml.yU + ">";
		if (this.gY()) {
			this._h2.forEachChildF(0, function (el) {
				var temp = this.xO(this.render_row_tree(-1, el.id));
				out.push(temp);
				if (temp) {
					return true;
				} else {
					return false;
				}
			}, this, function () {
				out.push(close);
			});
		} else {
			for (var i = 0; i < this.aD.length; i++) {
				if (this.aD[i]) {
					var temp = this.xO(this.render_row(i));
					out.push(temp);
					if (temp) {
						out.push(close);
					}
				}
			}
		}
		return [out.join("")];
	};
	this.xO = function (r, i) {
		var out = [];
		var ra = this.xml.row_attrs;
		var ca = this.xml.cell_attrs;
		out.push("<" + this.xml.yU);
		out.push(" id='" + r.idd + "'");
		if ((this.Jr) && this.bY.bP(r) != -1) {
			out.push(" selected='1'");
		}
		if (this._h2 && this._h2.get[r.idd].state == "minus") {
			out.push(" open='1'");
		}
		if (ra.length) {
			for (var i = 0; i < ra.length; i++) {
				out.push(" " + ra[i] + "='" + r._attrs[ra[i]] + "'");
			}
		}
		out.push(">");
		if (this.Jb && this.bH[r.idd]) {
			vU = this.bH[r.idd].Ln();
			for (var ii = 0; ii < vU.length; ii++) {
				out.push("<userdata name='" + vU[ii] + "'>" + (this.LB ? "<![CDATA[" : "") + this.bH[r.idd].get(vU[ii]) + (this.LB ? "]]>" : "") + "</userdata>");
			}
		}
		var xJ = false;
		for (var jj = 0; jj < this.gA; jj++) {
			if ((!this.nF) || (this.nF[jj])) {
				var zx = this.cells3(r, jj);
				out.push("<cell");
				if (ca.length) {
					for (var i = 0; i < ca.length; i++) {
						out.push(" " + ca[i] + "='" + zx.cell._attrs[ca[i]] + "'");
					}
				}
				wF = zx[this.zt]();
				if (this.LB) {
					wF = "<![CDATA[" + wF + "]]>";
				}
				if ((this.CP) && (zx.cell.colSpan) && zx.cell.colSpan > 1) {
					out.push(" colspan=\"" + zx.cell.colSpan + "\" ");
				}
				if (this.Zx) {
					if (zx.hy()) {
						out.push(" changed=\"1\"");
						xJ = true;
					}
				} else {
					if ((this.xq) && (zx.hy())) {
						xJ = true;
					}
				}
				if (this.Jr && this.cellType[jj] == "tree") {
					out.push((this._h2 ? (" image='" + this._h2.get[r.idd].image + "'") : "") + ">" + wF + "</cell>");
				} else {
					out.push(">" + wF + "</cell>");
				}
				if ((this.CP) && (zx.cell.colSpan)) {
					for (var u = 0; u < zx.cell.colSpan - 1; u++) {
						out.push("<cell/>");
						jj++;
					}
				}
			}
		}
		if ((this.xq) && (!xJ) && (!r.adM)) {
			return "";
		}
		return out.join("");
	};
	this.Aj = function () {
		var out = "<head>";
		for (var i = 0; i < this.hdr.rows[0].cells.length; i++) {
			if (this.nF && !this.nF[i]) {
				continue;
			}
			var sort = this.fldSort[i];
			if (sort == "cus") {
				sort = this._customSorts[i].toString();
				sort = sort.replace(/function[\ ]*/, "").replace(/\([^\f]*/, "");
			}
			out += "<column width='" + this.yI(i) + "' align='" + this.cellAlign[i] + "' type='" + this.cellType[i] + "' sort='" + (sort || "na") + "' color='" + this.columnColor[i] + "'" + (this.columnIds[i] ? (" id='" + this.columnIds[i] + "'") : "") + ">";
			if (this.LB) {
				out += "<![CDATA[" + this.wW(i) + "]]>";
			} else {
				out += this.wW(i);
			}
			var z = this.cf(i);
			if (z) {
				for (var j = 0; j < z.kk.length; j++) {
					out += "<option value='" + z.kk[j] + "'>" + z.values[j] + "</option>";
				}
			}
			out += "</column>";
		}
		return out += "</head>";
	};
	this.serialize = function () {
		var out = "<?xml version=\"1.0\"?><rows>";
		if (this.oX) {
			this.zt = "getMathValue";
		} else {
			this.zt = "getValue";
		}
		if (this.Jb && this.bH["gridglobaluserdata"]) {
			var vU = this.bH["gridglobaluserdata"].Ln();
			for (var i = 0; i < vU.length; i++) {
				out += "<userdata name='" + vU[i] + "'>" + this.bH["gridglobaluserdata"].get(vU[i]) + "</userdata>";
			}
		}
		if (this.Ld) {
			out += this.Aj();
		}
		out += this.JS();
		out += "</rows>";
		return out;
	};
	this.fI = function (PN, Bx) {
		if (!Bx && !_isChrome) {
			var pos = getOffset(PN);
			return [pos.left, pos.top];
		}
		Bx = Bx || document.body;
		var dJ = PN;
		var uW = 0;
		var AP = 0;
		while ((dJ) && (dJ != Bx)) {
			uW += dJ.offsetLeft - dJ.scrollLeft;
			AP += dJ.offsetTop - dJ.scrollTop;
			dJ = dJ.offsetParent;
		}
		if (Bx == document.body) {
			if (_isIE) {
				AP += document.body.offsetTop || document.documentElement.offsetTop;
				uW += document.body.offsetLeft || document.documentElement.offsetLeft;
			} else {
				if (!aq) {
					uW += document.body.offsetLeft;
					AP += document.body.offsetTop;
				}
			}
		}
		return [uW, AP];
	};
	this.bw = function (obj, tag) {
		while (obj && obj.tagName != tag && obj.tagName != "BODY") {
			obj = obj.parentNode;
		}
		return obj;
	};
	this.HF.onscroll = function () {
		this.grid._doOnScroll();
	};
	if ((!cU) || (pe > 8.5)) {
		this.hdr.onmousemove = function (e) {
			this.grid.bX(e || window.event);
		};
		this.hdr.onmousedown = function (e) {
			return this.grid.eJ(e || window.event);
		};
	}
	this.obj.onmousemove = this.Xj;
	this.obj.onclick = function (e) {
		this.grid.aV(e || window.event);
		if (this.grid.aU) {
			this.grid.gh(e || window.event);
		}
		(e || event).cancelBubble = true;
	};
	if (gP) {
		this.aL.oncontextmenu = function (e) {
			e.cancelBubble = true;
			e.returnValue = false;
			return this.grid._doContClick(e || window.event);
		};
	} else {
		this.aL.onmousedown = function (e) {
			return this.grid._doContClick(e || window.event);
		};
		this.aL.oncontextmenu = function (e) {
			if (this.grid.Gs) {
				(e || event).cancelBubble = true;
			}
			return !this.grid.Gs;
		};
	}
	this.obj.ondblclick = function (e) {
		if (!this.grid.gF(e || window.event)) {
			return false;
		}
		if (this.grid.aP) {
			var row = this.grid.bw((_isIE ? event.srcElement : e.target), "TR");
			if (row == this.grid.row) {
				this.grid.gh(e || window.event);
			}
		}
		(e || event).cancelBubble = true;
		if (cU) {
			return false;
		}
	};
	this.hdr.onclick = this.FJ;
	this.gB.onclick = function () {
		self.FJ.apply({grid:self}, [null, self.yH]);
	};
	this.hdr.ondblclick = this.LI;
	if (!document.body.FO) {
		dhtmlxEvent(document, cU ? "keypress" : "keydown", function (e) {
			if (globalActiveDHTMLGridObject) {
				return globalActiveDHTMLGridObject.bQ(e || window.event);
			}
		});
		document.body.FO = true;
	}
	dhtmlxEvent(document.body, "click", function () {
		if (self.editStop) {
			self.editStop();
		}
	});
	this.aL.onbeforeactivate = function () {
		this.QX = null;
		this.grid.setActive();
		event.cancelBubble = true;
	};
	this.aL.onbeforedeactivate = function () {
		if (this.grid.QX) {
			this.grid.QX = null;
		} else {
			this.grid.ft = false;
		}
		event.cancelBubble = true;
	};
	if (this.aL.style.height.toString().indexOf("%") != -1) {
		this._delta_y = this.aL.style.height;
	}
	if (this.aL.style.width.toString().indexOf("%") != -1) {
		this._delta_x = this.aL.style.width;
	}
	if (this._delta_x || this._delta_y) {
		this.tZ();
	}
	this.FM = this.abt;
	this.enableCollSpan = this.enableColSpan;
	this.Rn = this.enableMultiselect;
	this.CB = this.enableMultiline;
	this.iu = this.Yb;
	this.bI = this.acg;
	this.wW = this.adE;
	this.Xu = this.aai;
	this.So = this.adG;
	this.dX = this.selectRowById;
	this.Cs = this.adA;
	this.jJ = this.vq;
	this.enableAutoHeigth = this.enableAutoHeight;
	this.iH = this.uid;
	if (dhtmlx.image_path) {
		this.setImagePath(dhtmlx.image_path);
	}
	if (dhtmlx.skin) {
		this.setSkin(dhtmlx.skin);
	}
	return this;
}
dhtmlXGridObject.prototype = {getRowAttribute:function (id, name) {
	return this.dz(id)._attrs[name];
}, setRowAttribute:function (id, name, value) {
	this.dz(id)._attrs[name] = value;
}, gY:function () {
	return (this.cellType.bP("tree") != -1);
}, sO:function (id, state) {
	var f = ap(state);
	var row = this.dz(id);
	if (!row) {
		return;
	}
	if (row.expand === "") {
		this.collapseKids(row);
	}
	if ((state) && (row.style.display != "none")) {
		row.style.display = "none";
		var z = this.bY.bP(row);
		if (z != -1) {
			row.className = row.className.replace("rowselected", "");
			for (var i = 0; i < row.childNodes.length; i++) {
				row.childNodes[i].className = row.childNodes[i].className.replace(/cellselected/g, "");
			}
			this.bY.hd(z);
		}
		this.callEvent("onGridReconstructed", []);
	}
	if ((!state) && (row.style.display == "none")) {
		row.style.display = "";
		this.callEvent("onGridReconstructed", []);
	}
	this.setSizes();
}, setColumnHidden:function (ind, state) {
	if (!this.hdr.rows.length) {
		if (!this.Az) {
			this.Az = [];
		}
		return this.Az[ind] = state;
	}
	if ((this.ij) && (this.ij.cellIndex == ind) && (state)) {
		this.gB.style.display = "none";
	}
	var f = ap(state);
	if (f) {
		if (!this._hrrar) {
			this._hrrar = new Array();
		} else {
			if (this._hrrar[ind]) {
				return;
			}
		}
		this._hrrar[ind] = "display:none;";
		this.wx(ind, "none");
	} else {
		if ((!this._hrrar) || (!this._hrrar[ind])) {
			return;
		}
		this._hrrar[ind] = "";
		this.wx(ind, "");
	}
	if ((this.ij) && (this.ij.cellIndex == ind) && (!state)) {
		this.gB.style.display = "inline";
	}
	this.vo();
	this.callEvent("onColumnHidden", [ind, state]);
}, Fs:function (ind) {
	if ((this._hrrar) && (this._hrrar[ind])) {
		return true;
	}
	return false;
}, abt:function (list) {
	if (list) {
		this.Az = list.split(this.gX);
	}
	if (this.hdr.rows.length && this.Az) {
		for (var i = 0; i < this.Az.length; i++) {
			this.setColumnHidden(i, this.Az[i]);
		}
	}
}, pM:function (pb, ind, Nq, state, index) {
	index = index || "_cellIndex";
	var z = pb.rows.length;
	for (var i = 0; i < z; i++) {
		var x = pb.rows[i].childNodes;
		if (x.length != this.gA) {
			for (var j = 0; j < x.length; j++) {
				if (x[j][index] == ind) {
					x[j].style[Nq] = state;
					break;
				}
			}
		} else {
			x[ind].style[Nq] = state;
		}
	}
}, wx:function (ind, state) {
	var OC = ind;
	if ((this.hdr.rows[1].bq) && (this.hdr.rows[1].bq[ind] != ind)) {
		OC = this.hdr.rows[1].bq[ind];
	}
	if (state == "none") {
		this.hdr.rows[0].cells[ind].uE = this.hdr.rows[0].cells[ind].style.width || (this.initCellWidth[ind] + "px");
		this.hdr.rows[0].cells[ind].Ce = this.cellWidthPC[ind];
		this.obj.rows[0].cells[ind].style.width = "0px";
		var t = {rows:[this.obj.rows[0]]};
		this.forEachRow(function (id) {
			if (this.bj[id].tagName == "TR") {
				t.rows.push(this.bj[id]);
			}
		});
		this.pM(t, ind, "display", "none");
		if (this.gY()) {
			this.oj(ind, "none");
		}
		if ((cU && pe < 9) || cn || (aq)) {
			this.pM(this.hdr, ind, "display", "none", "_cellIndexS");
		}
		if (this.ftr) {
			this.pM(this.ftr.childNodes[0], ind, "display", "none");
		}
		this.pM(this.hdr, ind, "whiteSpace", "nowrap", "_cellIndexS");
		if (!this.cellWidthPX.length && !this.cellWidthPC.length) {
			this.cellWidthPX = [].concat(this.initCellWidth);
		}
		if (this.cellWidthPX[ind]) {
			this.cellWidthPX[ind] = 0;
		}
		if (this.cellWidthPC[ind]) {
			this.cellWidthPC[ind] = 0;
		}
	} else {
		if (this.hdr.rows[0].cells[ind].uE) {
			var zrow = this.hdr.rows[0].cells[ind];
			if (cU || cn || (aq)) {
				this.pM(this.hdr, ind, "display", "", "_cellIndexS");
			}
			if (this.ftr) {
				this.pM(this.ftr.childNodes[0], ind, "display", "");
			}
			var t = {rows:[this.obj.rows[0]]};
			this.forEachRow(function (id) {
				if (this.bj[id].tagName == "TR") {
					t.rows.push(this.bj[id]);
				}
			});
			this.pM(t, ind, "display", "");
			if (this.gY()) {
				this.oj(ind, "");
			}
			this.pM(this.hdr, ind, "whiteSpace", "normal", "_cellIndexS");
			if (zrow.Ce) {
				this.cellWidthPC[ind] = zrow.Ce;
			}
			if (zrow.uE) {
				this.cellWidthPX[ind] = parseInt(zrow.uE);
			}
		}
	}
	this.setSizes();
	if ((!_isIE) && (!aq)) {
		this.obj.border = 1;
		this.obj.border = 0;
	}
}, enableColSpan:function (mode) {
	this.CP = ap(mode);
}, enableRowsHover:function (mode, afT) {
	this.Rz(false, true);
	this.Lk = afT;
	if (ap(mode)) {
		if (!this.Qh) {
			this.obj.Io = this.obj.onmousemove;
			this.obj.onmousemove = this.ff;
			if (_isIE) {
				this.obj.onmouseleave = this.Rz;
			} else {
				this.obj.onmouseout = this.Rz;
			}
			this.Qh = true;
		}
	} else {
		if (this.Qh) {
			this.obj.onmousemove = this.obj.Io;
			if (_isIE) {
				this.obj.onmouseleave = null;
			} else {
				this.obj.onmouseout = null;
			}
			this.Qh = false;
		}
	}
}, rg:function (click, dblclick, anG) {
	this.aU = ap(click);
	this.aP = ap(dblclick);
	this.UB = ap(anG);
}, enableLightMouseNavigation:function (mode) {
	if (ap(mode)) {
		if (!this.UJ) {
			this.aL.age = this.aL.onclick;
			this.aL.onclick = function () {
				return true;
			};
			this.obj.age = this.obj.onclick;
			this.obj.onclick = function (e) {
				var c = this.grid.bw(e ? e.target : event.srcElement, "TD");
				if (!c) {
					return;
				}
				this.grid.editStop();
				this.grid.doClick(c);
				this.grid.gh();
				(e || event).cancelBubble = true;
			};
			this.obj.KA = this.obj.onmousemove;
			this.obj.onmousemove = this.Oy;
			this.UJ = true;
		}
	} else {
		if (this.UJ) {
			this.aL.onclick = this.aL.age;
			this.obj.onclick = this.obj.age;
			this.obj.onmousemove = this.obj.KA;
			this.UJ = false;
		}
	}
}, Rz:function (e, c) {
	if (c) {
		that = this;
	} else {
		that = this.grid;
	}
	if ((that.Fr) && (that.Fr != c)) {
		for (var i = 0; i < that.Fr.childNodes.length; i++) {
			that.Fr.childNodes[i].className = that.Fr.childNodes[i].className.replace(that.Lk, "");
		}
		that.Fr = null;
	}
}, ff:function (e) {
	var c = this.grid.bw(e ? e.target : event.srcElement, "TD");
	if (c && c.parentNode != this.grid.Fr) {
		this.grid.Rz(0, c);
		c = c.parentNode;
		if (!c.idd || c.idd == "__filler__") {
			return;
		}
		for (var i = 0; i < c.childNodes.length; i++) {
			c.childNodes[i].className += " " + this.grid.Lk;
		}
		this.grid.Fr = c;
	}
	this.Io(e);
}, Oy:function (e) {
	if (!this.grid.editor) {
		var c = this.grid.bw(e ? e.target : event.srcElement, "TD");
		if (c.parentNode.idd) {
			this.grid.doClick(c, true, 0);
		}
	}
	this.KA(e);
}, enableDistributedParsing:function (mode, count, EP) {
	if (ap(mode)) {
		this.Hv = count || 10;
		this.Kb = EP || 250;
	} else {
		this.Hv = 0;
	}
}, fA:function () {
	this.editStop(true);
	if (this.zY) {
		this.zY = window.clearTimeout(this.zY);
	}
	this.aL.className = (this.aL.className || "").replace(/gridbox.*/, "");
	if (this.vn) {
		for (var i = 0; i < this.vn.length; i++) {
			this.qs.removeChild(this.vn[i]);
		}
	}
	var a;
	this.bA = this.bA.fA();
	for (var i = 0; i < this.am.length; i++) {
		if (this.am[i]) {
			this.am[i].grid = null;
		}
	}
	for (i in this.bj) {
		if (this.bj[i]) {
			this.bj[i] = null;
		}
	}
	this.am = new dhtmlxArray();
	this.bj = new Array();
	this.aL.innerHTML = "";
	var lZ = function () {
	};
	this.aL.onclick = this.aL.onmousedown = this.aL.onbeforeactivate = this.aL.onbeforedeactivate = this.aL.onbeforedeactivate = this.aL.onselectstart = lZ;
	this.setSizes = this._update_srnd_view = this.callEvent = lZ;
	this.aL.grid = this.HF.grid = this.kR.grid = this.obj.grid = this.hdr.grid = null;
	for (a in this) {
		if ((this[a]) && (this[a].yO)) {
			this[a].yO = null;
		}
		this[a] = null;
	}
	if (this == globalActiveDHTMLGridObject) {
		globalActiveDHTMLGridObject = null;
	}
	return null;
}, xu:function () {
	var z = new Array();
	if (this.ij) {
		z[0] = this.ij._cellIndex;
		z[1] = (this.gB.src.indexOf("sort_desc.gif") != -1) ? "des" : "asc";
	}
	return z;
}, enableAutoHeight:function (mode, maxHeight, Ql) {
	this.abK = ap(mode);
	this.aea = ap(Ql);
	this.FF = maxHeight || null;
	if (arguments.length == 1) {
		this.HF.style.overflowY = mode ? "hidden" : "auto";
	}
	if (maxHeight == "auto") {
		this.FF = null;
		this.aic = true;
		this.tZ();
	}
}, enableStableSorting:function (mode) {
	this.agg = ap(mode);
	this.am.stablesort = function (arj) {
		var size = this.length - 1;
		for (var i = 0; i < this.length - 1; i++) {
			for (var j = 0; j < size; j++) {
				if (arj(this[j], this[j + 1]) > 0) {
					var temp = this[j];
					this[j] = this[j + 1];
					this[j + 1] = temp;
				}
			}
			size--;
		}
	};
}, enableKeyboardSupport:function (mode) {
	this.Zl = !ap(mode);
}, enableContextMenu:function (menu) {
	this.Gs = menu;
}, Tk:function (width) {
}, aja:function (list) {
	this.FB = list.split(",");
	for (var i = 0; i < this.FB.length; i++) {
		this.FB[i] = ap(this.FB[i]);
	}
}, aik:function (list) {
	this.qZ = list.split(",");
	for (var i = 0; i < this.qZ.length; i++) {
		this.qZ[i] = ap(this.qZ[i]);
	}
}, mE:function (width, ind) {
	if (arguments.length == 2) {
		if (!this._drsclmW) {
			this._drsclmW = new Array();
		}
		this._drsclmW[ind] = width;
	} else {
		this._drsclmW = width.split(",");
	}
}, enableCellIds:function (mode) {
	this.ajm = ap(mode);
}, ty:function (cq, mode) {
	var z = this.dz(cq);
	if (z) {
		z.FG = ap(mode);
		if ((this.cell) && (this.cell.parentNode.idd == cq)) {
			this.editStop();
		}
	}
}, Vf:function (row) {
	var text = new Array();
	for (var ii = 0; ii < row.childNodes.length; ii++) {
		var a = this.cells3(row, ii);
		text[ii] = a.getValue();
	}
	return text;
}, setDateFormat:function (mask, incoming) {
	this.RY = mask;
	this._dtmask_inc = incoming;
}, kr:function (mask, vF, p_sep, d_sep) {
	var yJ = mask.replace(/[^0\,\.]*/g, "");
	var yb = yJ.indexOf(".");
	if (yb > -1) {
		yb = yJ.length - yb - 1;
	}
	var Jd = yJ.indexOf(",");
	if (Jd > -1) {
		Jd = yJ.length - yb - 2 - Jd;
	}
	if (typeof p_sep != "string") {
		p_sep = this.i18n.decimal_separator;
	}
	if (typeof d_sep != "string") {
		d_sep = this.i18n.group_separator;
	}
	var apG = mask.split(yJ)[0];
	var Om = mask.split(yJ)[1];
	this._maskArr[vF] = [yb, Jd, apG, Om, p_sep, d_sep];
}, Sl:function (data, ind) {
	var a = this._maskArr[ind];
	if (!a) {
		return data;
	}
	var ndata = parseFloat(data.toString().replace(/[^0-9]*/g, ""));
	if (data.toString().substr(0, 1) == "-") {
		ndata = ndata * -1;
	}
	if (a[0] > 0) {
		ndata = ndata / Math.pow(10, a[0]);
	}
	return ndata;
}, PH:function (data, ind) {
	var a = this._maskArr[ind];
	if (!a) {
		return data;
	}
	var c = (parseFloat(data) < 0 ? "-" : "") + a[2];
	data = Math.abs(Math.round(parseFloat(data) * Math.pow(10, a[0] > 0 ? a[0] : 0))).toString();
	data = (data.length < a[0] ? Math.pow(10, a[0] + 1 - data.length).toString().substr(1, a[0] + 1) + data.toString() : data).split("").reverse();
	data[a[0]] = (data[a[0]] || "0") + a[4];
	if (a[1] > 0) {
		for (var j = (a[0] > 0 ? 0 : 1) + a[0] + a[1]; j < data.length; j += a[1]) {
			data[j] += a[5];
		}
	}
	return c + data.reverse().join("") + a[3];
}, DV:function (arr) {
	for (var i = 0; i < arr.length; i++) {
		var CF = new Array();
		for (var j = 0; j < arr[i].childNodes.length; j++) {
			if (arr[i].childNodes[j].nodeType == 1) {
				CF[CF.length] = arr[i].childNodes[j].firstChild.data;
			}
		}
		this[arr[i].getAttribute("command")].apply(this, CF);
	}
}, Ov:function (ai) {
	var Cv = this.bA.et("./head", ai);
	if (Cv.length) {
		var cQ = this.bA.et("./column", Cv[0]);
		var sp = this.bA.et("./settings", Cv[0]);
		var SJ = "setInitWidths";
		var split = false;
		if (sp[0]) {
			for (var s = 0; s < sp[0].childNodes.length; s++) {
				switch (sp[0].childNodes[s].tagName) {
				  case "colwidth":
					if (sp[0].childNodes[s].firstChild && sp[0].childNodes[s].firstChild.data == "%") {
						SJ = "setInitWidthsP";
					}
					break;
				  case "splitat":
					split = (sp[0].childNodes[s].firstChild ? sp[0].childNodes[s].firstChild.data : false);
					break;
				}
			}
		}
		this.DV(this.bA.et("./beforeInit/call", Cv[0]));
		if (cQ.length > 0) {
			if (this.hdr.rows.length > 0) {
				this.clearAll(true);
			}
			var sets = [[], [], [], [], [], [], [], [], []];
			var attrs = ["", "width", "type", "align", "sort", "color", "format", "hidden", "id"];
			var calls = ["", SJ, "setColTypes", "setColAlign", "setColSorting", "setColumnColor", "", "", "setColumnIds"];
			for (var i = 0; i < cQ.length; i++) {
				for (var j = 1; j < attrs.length; j++) {
					sets[j].push(cQ[i].getAttribute(attrs[j]));
				}
				sets[0].push((cQ[i].firstChild ? cQ[i].firstChild.data : "").replace(/^\s*((\s\S)*.+)\s*$/gi, "$1"));
			}
			this.setHeader(sets[0]);
			for (var i = 0; i < calls.length; i++) {
				if (calls[i]) {
					this[calls[i]](sets[i].join(this.gX));
				}
			}
			for (var i = 0; i < cQ.length; i++) {
				if ((this.cellType[i].indexOf("co") == 0) || (this.cellType[i] == "clist")) {
					var hJ = this.bA.et("./option", cQ[i]);
					if (hJ.length) {
						var aao = new Array();
						if (this.cellType[i] == "clist") {
							for (var j = 0; j < hJ.length; j++) {
								aao[aao.length] = hJ[j].firstChild ? hJ[j].firstChild.data : "";
							}
							this.AO(i, aao);
						} else {
							var combo = this.cf(i);
							for (var j = 0; j < hJ.length; j++) {
								combo.eT(hJ[j].getAttribute("value"), hJ[j].firstChild ? hJ[j].firstChild.data : "");
							}
						}
					}
				} else {
					if (sets[6][i]) {
						if ((this.cellType[i].toLowerCase().indexOf("calendar") != -1) || (this.fldSort[i] == "date")) {
							this.setDateFormat(sets[6][i]);
						} else {
							this.kr(sets[6][i], i);
						}
					}
				}
			}
			this.init();
			var param = sets[7].join(this.gX);
			if (this.FM && param.replace(/,/g, "") != "") {
				this.FM(param);
			}
			if ((split) && (this.tT)) {
				this.tT(split);
			}
		}
		this.DV(this.bA.et("./afterInit/call", Cv[0]));
	}
	var Kh = this.bA.et("//rows/userdata", ai);
	if (Kh.length > 0) {
		if (!this.bH["gridglobaluserdata"]) {
			this.bH["gridglobaluserdata"] = new qB();
		}
		for (var j = 0; j < Kh.length; j++) {
			this.bH["gridglobaluserdata"].eT(Kh[j].getAttribute("name"), Kh[j].firstChild ? Kh[j].firstChild.data : "");
		}
	}
}, aiZ:function (mf) {
	var d = new Array();
	this.forEachRowA(function (id) {
		if (this.cells(id, mf).getValue() != 0) {
			d.push(id);
		}
	}, true);
	return d.join(",");
}, checkAll:function () {
	var mode = arguments.length ? arguments[0] : 1;
	for (var vF = 0; vF < this.adG(); vF++) {
		if (this.abv(vF) == "ch") {
			this.setCheckedRows(vF, mode);
		}
	}
}, uncheckAll:function () {
	this.checkAll(0);
}, setCheckedRows:function (vF, v) {
	this.forEachRowA(function (id) {
		if (this.cells(id, vF).wI()) {
			this.cells(id, vF).setValue(v);
		}
	});
}, Xj:function (e) {
	var c = this.grid.bw(e ? e.target : event.srcElement, "TD");
	if (!c || ((this.grid.editor) && (this.grid.editor.cell == c))) {
		return true;
	}
	var r = c.parentNode;
	if (!r.idd || r.idd == "__filler__") {
		return;
	}
	var el = (e ? e.target : event.srcElement);
	if (r.idd == window.unknown) {
		return true;
	}
	if (!this.grid.callEvent("onMouseOver", [r.idd, c._cellIndex, (e || window.event)])) {
		return true;
	}
	if ((this.grid.FB) && (!this.grid.FB[c._cellIndex])) {
		if (el.title) {
			el.title = "";
		}
		return true;
	}
	if (c._cellIndex >= this.grid.gA) {
		return;
	}
	var acT = this.grid.cells3(r, c._cellIndex);
	if (!acT || !acT.cell || !acT.cell._attrs) {
		return;
	}
	if (el.ahi) {
		acT.cell.title = "";
	}
	if (!acT.cell._attrs["title"]) {
		el.ahi = true;
	}
	if (acT) {
		el.title = acT.cell._attrs["title"] || (acT.getTitle ? acT.getTitle() : (acT.getValue() || "").toString().replace(/<[^>]*>/gi, ""));
	}
	return true;
}, UH:function (size) {
	if (aq) {
		this.Wr = parseInt(size);
	}
}, aau:function (separator) {
	var ar = [];
	for (var i = 0; i < this.aD.length; i++) {
		if (this.aD[i]) {
			ar.push(this.aD[i].idd);
		}
	}
	return ar.join(separator || this.gX);
}, Iy:function () {
	return this.aau();
}, Oq:function (bO, mf, colspan) {
	if (!this.CP) {
		return;
	}
	var r = this.dz(bO);
	if ((r.bq) && (r.childNodes[r.bq[mf]])) {
		var j = r.bq[mf];
		var n = r.childNodes[j];
		var m = n.colSpan;
		n.colSpan = 1;
		if ((m) && (m != 1)) {
			for (var i = 1; i < m; i++) {
				var c = document.createElement("TD");
				if (n.nextSibling) {
					r.insertBefore(c, n.nextSibling);
				} else {
					r.appendChild(c);
				}
				r.bq[mf + i] = j + i;
				c._cellIndex = mf + i;
				c.style.textAlign = this.cellAlign[i];
				c.style.verticalAlign = this.cellVAlign[i];
				n = c;
				this.cells3(r, mf + i).setValue("");
			}
		}
		for (var z = mf * 1 + 1 * m; z < r.bq.length; z++) {
			r.bq[z] += (m - 1) * 1;
		}
	}
	if ((colspan) && (colspan > 1)) {
		if (r.bq) {
			var j = r.bq[mf];
		} else {
			var j = mf;
			r.bq = new Array();
			for (var z = 0; z < r.childNodes.length; z++) {
				r.bq[z] = z;
			}
		}
		r.childNodes[j].colSpan = colspan;
		for (var z = 1; z < colspan; z++) {
			r.bq[r.childNodes[j + 1]._cellIndex] = j;
			r.removeChild(r.childNodes[j + 1]);
		}
		var c1 = r.childNodes[r.bq[mf]]._cellIndex;
		for (var z = c1 * 1 + 1 * colspan; z < r.bq.length; z++) {
			r.bq[z] -= (colspan - 1);
		}
	}
}, vq:function (mode) {
	this.ir = ap(mode);
	this.bA.hN = this.ir;
}, HG:function (mode) {
	this.anu = ap(mode);
}, LI:function (e) {
	var that = this.grid;
	var el = that.bw(_isIE ? event.srcElement : e.target, "TD");
	if (!that.anu) {
		return false;
	}
	that.nT(el._cellIndexS);
}, 
//-----------------------------mlq2011-1-11---adjustColumnSize---start--------------------
adjustColumnSize:function(complex){
	for( var cInd = 1;cInd < this.hdrLabels.length; cInd++){
		this.nT(cInd, complex);
	}
},
//-----------------------------mlq2011-1-11---adjustColumnSize---end---------------------
nT:function (vF, complex) {
	if (this._hrrar && this._hrrar[vF]) {
		return;
	}
	this.Hc = true;
	var m = 0;
	this.si(vF, 20);
	for (var j = 1; j < this.hdr.rows.length; j++) {
		var a = this.hdr.rows[j];
		a = a.childNodes[(a.bq) ? a.bq[vF] : vF];
		if ((a) && ((!a.colSpan) || (a.colSpan < 2)) && a._cellIndex == vF) {
			if ((a.childNodes[0]) && (a.childNodes[0].className == "hdrcell")) {
				a = a.childNodes[0];
			}
			m = Math.max(m, ((aq || cU) ? (a.textContent.length * 7) : a.scrollWidth));
		}
	}
	var l = this.obj.rows.length;
	for (var i = 1; i < l; i++) {
		var z = this.obj.rows[i];
		if (!this.bj[z.idd]) {
			continue;
		}
		if (z.bq && z.bq[vF] != vF || !z.childNodes[vF]) {
			continue;
		}
		if (aq || cU || complex) {
			z = z.childNodes[vF].textContent.length * 7;
		} else {
			z = z.childNodes[vF].scrollWidth;
		}
		if (z > m) {
			m = z;
		}
	}
	m += 20 + (complex || 0);
	this.si(vF, m);
	this.Hc = false;
	this.setSizes();
}, gz:function (index, hdr) {
	hdr = hdr || this.hdr;
	var row = hdr.rows[index + 1];
	if (row) {
		row.parentNode.removeChild(row);
	}
	this.setSizes();
}, iS:function (index) {
	this.gz(index, this.ftr);
}, attachHeader:function (values, style, wT) {
	if (typeof (values) == "string") {
		values = this.ZK(values);
	}
	if (typeof (style) == "string") {
		style = style.split(this.gX);
	}
	wT = wT || "_aHead";
	if (this.hdr.rows.length) {
		if (values) {
			this.Yw([values, style], this[(wT == "_aHead") ? "hdr" : "ftr"]);
		} else {
			if (this[wT]) {
				for (var i = 0; i < this[wT].length; i++) {
					this.attachHeader.apply(this, this[wT][i]);
				}
			}
		}
	} else {
		if (!this[wT]) {
			this[wT] = new Array();
		}
		this[wT][this[wT].length] = [values, style, wT];
	}
}, Yw:function (data, parent) {
	if (!parent) {
		if (this.aL.style.position != "absolute") {
			this.aL.style.position = "relative";
		}
		var z = document.createElement("DIV");
		z.className = "c_ftr".substr(2);
		this.aL.appendChild(z);
		var t = document.createElement("TABLE");
		t.cellPadding = t.cellSpacing = 0;
		if (!_isIE) {
			t.width = "100%";
			t.style.paddingRight = "20px";
		}
		t.style.marginRight = "20px";
		t.style.tableLayout = "fixed";
		z.appendChild(t);
		t.appendChild(document.createElement("TBODY"));
		this.ftr = parent = t;
		var hdrRow = t.insertRow(0);
		var arR = ((this.hdrLabels.length <= 1) ? data[0].length : this.hdrLabels.length);
		for (var i = 0; i < arR; i++) {
			hdrRow.appendChild(document.createElement("TH"));
			hdrRow.childNodes[i]._cellIndex = i;
		}
		if (_isIE && _isIE < 8) {
			hdrRow.style.position = "absolute";
		} else {
			hdrRow.style.height = "auto";
		}
	}
	var apc = data[1];
	var z = document.createElement("TR");
	parent.rows[0].parentNode.appendChild(z);
	for (var i = 0; i < data[0].length; i++) {
		if (data[0][i] == "#cspan") {
			var pz = z.cells[z.cells.length - 1];
			pz.colSpan = (pz.colSpan || 1) + 1;
			continue;
		}
		if ((data[0][i] == "#rspan") && (parent.rows.length > 1)) {
			var als = parent.rows.length - 2;
			var found = false;
			var pz = null;
			while (!found) {
				var pz = parent.rows[als];
				for (var j = 0; j < pz.cells.length; j++) {
					if (pz.cells[j]._cellIndex == i) {
						found = j + 1;
						break;
					}
				}
				als--;
			}
			pz = pz.cells[found - 1];
			pz.rowSpan = (pz.rowSpan || 1) + 1;
			continue;
		}
		var w = document.createElement("TD");
		w._cellIndex = w._cellIndexS = i;
		if (this._hrrar && this._hrrar[i] && !_isIE) {
			w.style.display = "none";
		}
		if (typeof data[0][i] == "object") {
			w.appendChild(data[0][i]);
		} else {
			if (this.qW) {
				w.innerHTML = "<div class='hdrcell'>" + (data[0][i] || "&nbsp;") + "</div>";
			} else {
				w.innerHTML = (data[0][i] || "&nbsp;");
			}
			if ((data[0][i] || "").indexOf("#") != -1) {
				var t = data[0][i].match(/(^|{)#([^}]+)(}|$)/);
				if (t) {
					var tn = "_in_header_" + t[2];
					if (this[tn]) {
						this[tn]((this.qW ? w.firstChild : w), i, data[0][i].split(t[0]));
					}
				}
			}
		}
		if (apc) {
			w.style.cssText = apc[i];
		}
		z.appendChild(w);
	}
	var self = parent;
	if (cn) {
		if (parent.Ze) {
			window.clearTimeout(parent.Ze);
		}
		parent.Ze = window.setTimeout(function () {
			parent.rows[1].style.display = "none";
			window.setTimeout(function () {
				parent.rows[1].style.display = "";
			}, 1);
		}, 500);
	}
}, attachFooter:function (values, style) {
	this.attachHeader(values, style, "_aFoot");
}, Me:function (cq, cellIndex, type) {
	this.tW(this.dz(cq), cellIndex, type);
}, tW:function (r, ind, type) {
	type = type || this.cellType[ind];
	var z = this.cells3(r, ind);
	var v = z.getValue();
	z.cell.zk = type;
	var z = this.cells3(r, ind);
	z.setValue(v);
}, CX:function (cq, type) {
	var z = this.bj[cq];
	for (var i = 0; i < z.childNodes.length; i++) {
		this.tW(z, i, type);
	}
}, IP:function (colIndex, type) {
	for (var i = 0; i < this.aD.length; i++) {
		if (this.aD[i] && this.aD[i].tagName == "TR") {
			this.tW(this.aD[i], colIndex, type);
		}
	}
	if (this.cellType[colIndex] == "math") {
		this.dA[i] = type;
	} else {
		this.cellType[colIndex] = type;
	}
}, forEachRow:function (Fi) {
	for (var a in this.bj) {
		if (this.bj[a] && this.bj[a].idd) {
			Fi.apply(this, [this.bj[a].idd]);
		}
	}
}, forEachRowA:function (Fi) {
	for (var a = 0; a < this.aD.length; a++) {
		if (this.aD[a]) {
			Fi.call(this, this.render_row(a).idd);
		}
	}
}, amz:function (cq, Fi) {
	var z = this.dz(cq);
	if (!z) {
		return;
	}
	for (var i = 0; i < this.gA; i++) {
		Fi(this.cells3(z, i), i);
	}
}, enableAutoWidth:function (mode, ady, acx) {
	this.Gd = [ap(mode), parseInt(ady || 99999), parseInt(acx || 0)];
	if (arguments.length == 1) {
		this.HF.style.overflowX = mode ? "hidden" : "auto";
	}
}, TJ:function (url, ack, aar, bo) {
	if (typeof ack == "undefined") {
		ack = true;
	}
	this.cZ = [true, ack, aar];
	this.load(url, bo);
}, OR:function (xml) {
	if (this._f_rowsBuffer) {
		this.GF(0, "");
	}
	reset = false;
	if (window.eXcell_tree) {
		eXcell_tree.prototype.Tw = eXcell_tree.prototype.setValue;
		eXcell_tree.prototype.setValue = function (content) {
			var r = this.grid._h2.get[this.cell.parentNode.idd];
			if (r && this.cell.parentNode.JT) {
				this.setLabel(content);
			} else {
				this.Tw(content);
			}
		};
	}
	var tree = this.cellType.bP("tree");
	xml.cR("rows");
	var qc = xml.et("//rows")[0].getAttribute("parent") || 0;
	var del = {};
	if (this.cZ[2]) {
		if (tree != -1) {
			this._h2.so(qc, function (obj) {
				del[obj.id] = true;
			}, this);
		} else {
			this.forEachRow(function (id) {
				del[id] = true;
			});
		}
	}
	var rows = xml.et("//row");
	for (var i = 0; i < rows.length; i++) {
		var row = rows[i];
		var id = row.getAttribute("id");
		del[id] = false;
		var qc = row.parentNode.getAttribute("id") || qc;
		if (this.bj[id] && this.bj[id].tagName != "TR") {
			if (this._h2) {
				this._h2.get[id].buff.data = row;
			} else {
				this.aD[this.getRowIndex(id)].data = row;
			}
			this.bj[id] = row;
		} else {
			if (this.bj[id]) {
				this._process_xml_row(this.bj[id], row, -1);
				this.jQ(this.bj[id], true);
			} else {
				if (this.cZ[1]) {
					var dadd = {idd:id, data:row, _parser:this._process_xml_row, _locator:this._get_xml_data};
					if (this.cZ[1] == "top") {
						this.aD.unshift(dadd);
					} else {
						this.aD.push(dadd);
					}
					if (this._h2) {
						reset = true;
						(this._h2.add(id, (row.parentNode.getAttribute("id") || row.parentNode.getAttribute("parent")))).buff = this.aD[this.aD.length - 1];
					}
					this.bj[id] = row;
					row = this.render_row(this.aD.length - 1);
					this._insertRowAt(row, -1);
				}
			}
		}
	}
	if (this.cZ[2]) {
		for (id in del) {
			if (del[id] && this.bj[id]) {
				this.deleteRow(id);
			}
		}
	}
	this.cZ = null;
	if (window.eXcell_tree) {
		eXcell_tree.prototype.setValue = eXcell_tree.prototype.Tw;
	}
	if (reset) {
		this.uR();
	}
	if (this._f_rowsBuffer) {
		this._f_rowsBuffer = null;
		this.EJ();
	}
}, iq:function (id, ind) {
	var cell = this.cells(id, ind).cell;
	if (!cell.cl) {
		cell.cl = new dhtmlXGridComboObject();
	}
	return cell.cl;
}, aaK:function (order) {
	var t = order.split(this.gX);
	this.Wq = [];
	var max = this.gA || order.length;
	for (var i = 0; i < max; i++) {
		t[i] = {c:parseInt(t[i]), ind:i};
	}
	t.sort(function (a, b) {
		return (a.c > b.c ? 1 : -1);
	});
	for (var i = 0; i < max; i++) {
		if (!t[i + 1] || (typeof t[i].c == "undefined")) {
			this.Wq[t[i].ind] = (t[0].ind + 1) * -1;
		} else {
			this.Wq[t[i].ind] = t[i + 1].ind;
		}
	}
}, i18n:{loading:"Loading", decimal_separator:".", group_separator:","}, zf:{k13_1_0:function () {
	var uH = this.am.bP(this.row);
	this.eQ(this.am[uH + 1], this.cell._cellIndex, true);
}, k13_0_1:function () {
	var uH = this.am.bP(this.row);
	this.eQ(this.am[uH - 1], this.cell._cellIndex, true);
}, k13_0_0:function () {
	this.editStop();
	this.callEvent("onEnter", [(this.row ? this.row.idd : null), (this.cell ? this.cell._cellIndex : null)]);
	this.QX = true;
}, k9_0_0:function () {
	this.editStop();
	if (!this.callEvent("onTab", [true])) {
		return true;
	}
	var z = this.Kn(null, 1);
	if (z) {
		this.eQ(z.parentNode, z._cellIndex, (this.row != z.parentNode), false, true);
		this.QX = true;
	}
}, k9_0_1:function () {
	this.editStop();
	if (!this.callEvent("onTab", [false])) {
		return false;
	}
	var z = this.Kn(null, -1);
	if (z) {
		this.eQ(z.parentNode, z._cellIndex, (this.row != z.parentNode), false, true);
		this.QX = true;
	}
}, k113_0_0:function () {
	if (this.UB) {
		this.gh();
	}
}, k32_0_0:function () {
	var c = this.cells4(this.cell);
	if (!c.changeState || (c.changeState() === false)) {
		return false;
	}
}, k27_0_0:function () {
	this.editStop(true);
}, k33_0_0:function () {
	if (this.aW) {
		this.changePage(this.ew - 1);
	} else {
		this.PP(-1);
	}
}, k34_0_0:function () {
	if (this.aW) {
		this.changePage(this.ew + 1);
	} else {
		this.PP(1);
	}
}, k37_0_0:function () {
	if (!this.editor && this.gY()) {
		this.collapseKids(this.row);
	} else {
		return false;
	}
}, k39_0_0:function () {
	if (!this.editor && this.gY()) {
		this.expandKids(this.row);
	} else {
		return false;
	}
}, k40_0_0:function () {
	var master = this.nh ? this.aC : this;
	if (this.editor && this.editor.combo) {
		this.editor.eW();
	} else {
		if (!this.row.idd) {
			return;
		}
		var uH = Math.max((master._r_select || 0), this.getRowIndex(this.row.idd)) + 1;
		if (this.aD[uH]) {
			master._r_select = null;
			this.eQ(uH, this.cell._cellIndex, true);
			if (master.aW) {
				master.aqG(master.bB(uH));
			}
		} else {
			this.zf.k34_0_0.apply(this, []);
			if (this.aW && this.am[uH]) {
				this.eQ(uH, 0, true);
			}
		}
	}
	this.QX = true;
}, k38_0_0:function () {
	var master = this.nh ? this.aC : this;
	if (this.editor && this.editor.combo) {
		this.editor.Kc();
	} else {
		if (!this.row.idd) {
			return;
		}
		var uH = this.getRowIndex(this.row.idd) + 1;
		if (uH != -1 && (!this.aW || (uH != 1))) {
			var NH = this.CE(uH - 1, -1);
			this.eQ(NH, this.cell._cellIndex, true);
			if (master.aW && NH) {
				master.aqG(NH.idd);
			}
		} else {
			this.zf.k33_0_0.apply(this, []);
		}
	}
	this.QX = true;
}}, _build_master_row:function () {
	var t = document.createElement("DIV");
	var html = ["<table><tr>"];
	for (var i = 0; i < this.gA; i++) {
		html.push("<td></td>");
	}
	html.push("</tr></table>");
	t.innerHTML = html.join("");
	this._master_row = t.firstChild.rows[0];
}, uO:function (oO) {
	if (!this._master_row) {
		this._build_master_row();
	}
	var r = this._master_row.cloneNode(true);
	for (var i = 0; i < r.childNodes.length; i++) {
		r.childNodes[i]._cellIndex = i;
		if (this.ajm) {
			r.childNodes[i].id = "c_" + oO + "_" + i;
		}
		if (this.nz) {
			this.ae.dS(r.childNodes[i], this);
		}
	}
	r.idd = oO;
	r.grid = this;
	return r;
}, _process_jsarray_row:function (r, data) {
	r._attrs = {};
	for (var j = 0; j < r.childNodes.length; j++) {
		r.childNodes[j]._attrs = {};
	}
	this.VQ(r, (this._c_order ? this.Xb(data) : data));
	return r;
}, _get_jsarray_data:function (data, ind) {
	return data[ind];
}, _process_json_row:function (r, data) {
	r._attrs = {};
	for (var j = 0; j < r.childNodes.length; j++) {
		r.childNodes[j]._attrs = {};
	}
	this.VQ(r, (this._c_order ? this.Xb(data.data) : data.data));
	return r;
}, _get_json_data:function (data, ind) {
	return data.data[ind];
}, _process_csv_row:function (r, data) {
	r._attrs = {};
	for (var j = 0; j < r.childNodes.length; j++) {
		r.childNodes[j]._attrs = {};
	}
	this.VQ(r, (this._c_order ? this.Xb(data.split(this.csv.cell)) : data.split(this.csv.cell)));
	return r;
}, _get_csv_data:function (data, ind) {
	return data.split(this.csv.cell)[ind];
}, _process_xml_row:function (r, xml) {
	var pg = this.bA.et(this.xml.cell, xml);
	var cD = [];
	r._attrs = this._xml_attrs(xml);
	if (this._ud_enabled) {
		var Pk = this.bA.et("./userdata", xml);
		for (var i = Pk.length - 1; i >= 0; i--) {
			this.setUserData(r.idd, Pk[i].getAttribute("name"), Pk[i].firstChild ? Pk[i].firstChild.data : "");
		}
	}
	for (var j = 0; j < pg.length; j++) {
		var tU = pg[this._c_order ? this._c_order[j] : j];
		if (!tU) {
			continue;
		}
		var cind = r.bq ? r.bq[j] : j;
		var aoT = tU.getAttribute("type");
		if (r.childNodes[cind]) {
			if (aoT) {
				r.childNodes[cind].zk = aoT;
			}
			r.childNodes[cind]._attrs = this._xml_attrs(tU);
		}
		if (!tU.getAttribute("xmlcontent")) {
			if (tU.firstChild) {
				tU = tU.firstChild.data;
			} else {
				tU = "";
			}
		}
		cD.push(tU);
	}
	for (j < pg.length; j < r.childNodes.length; j++) {
		r.childNodes[j]._attrs = {};
	}
	if (r.parentNode && r.parentNode.tagName == "row") {
		r._attrs["parent"] = r.parentNode.getAttribute("idd");
	}
	this.VQ(r, cD);
	return r;
}, _get_xml_data:function (data, ind) {
	data = data.firstChild;
	while (true) {
		if (!data) {
			return "";
		}
		if (data.tagName == "cell") {
			ind--;
		}
		if (ind < 0) {
			break;
		}
		data = data.nextSibling;
	}
	return (data.firstChild ? data.firstChild.data : "");
}, VQ:function (r, text) {
	if (this.editor) {
		this.editStop();
	}
	for (var i = 0; i < r.childNodes.length; i++) {
		if ((i < text.length) || (this.QL[i])) {
			var ii = r.childNodes[i]._cellIndex;
			var val = text[ii];
			var Lh = this.cells4(r.childNodes[i]);
			if ((this.QL[ii]) && ((val == "") || (typeof (val) == "undefined"))) {
				val = this.QL[ii];
			}
			if (Lh) {
				Lh.setValue(val);
			}
		} else {
			r.childNodes[i].innerHTML = "&nbsp;";
			r.childNodes[i].mG = true;
		}
	}
	return r;
}, jQ:function (r, donly) {
	if (r._attrs["class"]) {
		r.Vn = r.className = r._attrs["class"];
	}
	if (r._attrs.locked) {
		r.FG = true;
	}
	if (r._attrs.bgColor) {
		r.bgColor = r._attrs.bgColor;
	}
	var cor = 0;
	for (var i = 0; i < r.childNodes.length; i++) {
		var c = r.childNodes[i];
		var ii = c._cellIndex;
		var s = c._attrs.style || r._attrs.style;
		if (s) {
			c.style.cssText += ";" + s;
		}
		if (c._attrs["class"]) {
			c.className = c._attrs["class"];
		}
		s = c._attrs.align || this.cellAlign[ii];
		if (s) {
			c.align = s;
		}
		c.vAlign = c._attrs.valign || this.cellVAlign[ii];
		var color = c._attrs.bgColor || this.columnColor[ii];
		if (color) {
			c.bgColor = color;
		}
		if (c._attrs["colspan"] && !donly) {
			this.Oq(r.idd, i + cor, c._attrs["colspan"]);
			cor += (c._attrs["colspan"] - 1);
		}
		if (this._hrrar && this._hrrar[ii] && !donly) {
			c.style.display = "none";
		}
	}
	this.callEvent("onRowCreated", [r.idd, r, null]);
}, load:function (url, call, type) {
	this.callEvent("onXLS", [this]);
	if (arguments.length == 2 && typeof call != "function") {
		type = call;
		call = null;
	}
	type = type || "xml";
	if (!this.tR) {
		this.tR = url;
	}
	this._data_type = type;
	this.bA.UR = function (that, b, c, d, xml) {
		if (!that.callEvent) {
			return;
		}
		xml = that["_process_" + type](xml);
		if (!that.Bf) {
			that.callEvent("onXLE", [that, 0, 0, xml]);
		}
		if (call) {
			call();
			call = null;
		}
	};
	this.bA.loadXML(url);
}, loadXMLString:function (str, bo) {
	var t = new ag(function () {
	});
	t.loadXMLString(str);
	this.parse(t, bo, "xml");
}, loadXML:function (url, bo) {
	this.load(url, bo, "xml");
}, parse:function (data, call, type) {
	if (arguments.length == 2 && typeof call != "function") {
		type = call;
		call = null;
	}
	type = type || "xml";
	this._data_type = type;
	data = this["_process_" + type](data);
	if (!this.Bf) {
		this.callEvent("onXLE", [this, 0, 0, data]);
	}
	if (call) {
		call();
	}
}, xml:{top:"rows", row:"./row", cell:"./cell", yU:"row", s_cell:"cell", row_attrs:[], cell_attrs:[]}, csv:{row:"\n", cell:","}, _xml_attrs:function (node) {
	var data = {};
	if (node.attributes.length) {
		for (var i = 0; i < node.attributes.length; i++) {
			data[node.attributes[i].name] = node.attributes[i].value;
		}
	}
	return data;
}, _process_xml:function (xml) {
	if (!xml.et) {
		var t = new ag(function () {
		});
		if (typeof xml == "string") {
			t.loadXMLString(xml);
		} else {
			if (xml.responseXML) {
				t.ai = xml;
			} else {
				t.ai = {};
			}
			t.ai.responseXML = xml;
		}
		xml = t;
	}
	if (this.cZ) {
		return this.OR(xml);
	}
	this._parsing = true;
	var top = xml.cR(this.xml.top);
	if (top.tagName.toLowerCase() != this.xml.top) {
		return;
	}
	this.Ov(top);
	var rows = xml.et(this.xml.row, top);
	var cr = parseInt(xml.et("//" + this.xml.top)[0].getAttribute("pos") || 0);
	var total = parseInt(xml.et("//" + this.xml.top)[0].getAttribute("total_count") || 0);
	if (total && !this.aD[total - 1]) {
		this.aD[total - 1] = null;
	}
	if (this.gY()) {
		return this._process_tree_xml(xml);
	}
	for (var i = 0; i < rows.length; i++) {
		if (this.aD[i + cr]) {
			continue;
		}
		var id = rows[i].getAttribute("id") || (i + cr + 1);
		this.aD[i + cr] = {idd:id, data:rows[i], _parser:this._process_xml_row, _locator:this._get_xml_data};
		this.bj[id] = rows[i];
	}
	this.render_dataset();
	this._parsing = false;
	return xml.ai.responseXML ? xml.ai.responseXML : xml.ai;
}, _process_jsarray:function (data) {
	this._parsing = true;
	if (data && data.ai) {
		eval("data=" + data.ai.responseText + ";");
	}
	for (var i = 0; i < data.length; i++) {
		var id = i + 1;
		this.aD.push({idd:id, data:data[i], _parser:this._process_jsarray_row, _locator:this._get_jsarray_data});
		this.bj[id] = data[i];
	}
	this.render_dataset();
	this._parsing = false;
}, _process_csv:function (data) {
	this._parsing = true;
	if (data.ai) {
		data = data.ai.responseText;
	}
	data = data.replace(/\r/g, "");
	data = data.split(this.csv.row);
	if (this.KY) {
		this.clearAll();
		var thead = data.splice(0, 1)[0].split(this.csv.cell);
		if (!this.Sz) {
			thead.splice(0, 1);
		}
		this.setHeader(thead.join(this.gX));
		this.init();
	}
	for (var i = 0; i < data.length; i++) {
		if (!data[i] && i == data.length - 1) {
			continue;
		}
		if (this.Sz) {
			var id = i + 1;
			this.aD.push({idd:id, data:data[i], _parser:this._process_csv_row, _locator:this._get_csv_data});
		} else {
			var temp = data[i].split(this.csv.cell);
			var id = temp.splice(0, 1)[0];
			this.aD.push({idd:id, data:temp, _parser:this._process_jsarray_row, _locator:this._get_jsarray_data});
		}
		this.bj[id] = data[i];
	}
	this.render_dataset();
	this._parsing = false;
}, _process_json:function (data) {
	this._parsing = true;
	if (data && data.ai) {
		eval("data=" + data.ai.responseText + ";");
	}
	for (var i = 0; i < data.rows.length; i++) {
		var id = data.rows[i].id;
		this.aD.push({idd:id, data:data.rows[i], _parser:this._process_json_row, _locator:this._get_json_data});
		this.bj[id] = data[i];
	}
	this.render_dataset();
	this._parsing = false;
}, render_dataset:function (min, max) {
	if (this.ahK) {
		if (this._fillers) {
			return this._update_srnd_view();
		}
		max = Math.min((this._get_view_size() + (this._srnd_pr || 0)), this.aD.length);
	}
	if (this.aW) {
		min = Math.max((min || 0), (this.ew - 1) * this.cu);
		max = Math.min(this.ew * this.cu, this.aD.length);
	} else {
		min = min || 0;
		max = max || this.aD.length;
	}
	for (var i = min; i < max; i++) {
		var r = this.render_row(i);
		if (r == -1) {
			if (this.tR) {
				if (this.callEvent("onDynXLS", [i, (this.Cr ? this.Cr : (max - i))])) {
					this.load(this.tR + jv(this.tR) + "posStart=" + i + "&count=" + (this.Cr ? this.Cr : (max - i)), this._data_type);
				}
			}
			max = i;
			break;
		}
		if (!r.parentNode || !r.parentNode.tagName) {
			this._insertRowAt(r, i);
			if (r._attrs["selected"] || r._attrs["select"]) {
				this.Th(r, r._attrs["call"] ? true : false, true);
				r._attrs["selected"] = r._attrs["select"] = null;
			}
		}
		if (this.Hv && i - min == this.Hv) {
			var that = this;
			this._context_parsing = this._context_parsing || this._parsing;
			return this.Bf = window.setTimeout(function () {
				that.Bf = null;
				that.render_dataset(i, max);
				if (!that.Bf) {
					if (that._context_parsing) {
						that.callEvent("onXLE", []);
					} else {
						that._fixAlterCss();
					}
					that.callEvent("onDistributedEnd", []);
					that._context_parsing = false;
				}
			}, this.Kb);
		}
	}
	if (this.ahK && !this._fillers) {
		this._fillers = [this._add_filler(max, this.aD.length - max)];
	}
	this.setSizes();
}, render_row:function (ind) {
	if (!this.aD[ind]) {
		return -1;
	}
	if (this.aD[ind]._parser) {
		var r = this.aD[ind];
		if (this.bj[r.idd] && this.bj[r.idd].tagName == "TR") {
			return this.aD[ind] = this.bj[r.idd];
		}
		var row = this.uO(r.idd);
		this.aD[ind] = row;
		this.bj[r.idd] = row;
		r._parser.call(this, row, r.data);
		this.jQ(row);
		return row;
	}
	return this.aD[ind];
}, _get_cell_value:function (row, ind, method) {
	if (row._locator) {
		if (this._c_order) {
			ind = this._c_order[ind];
		}
		return row._locator.call(this, row.data, ind);
	}
	return this.cells3(row, ind)[method ? method : "getValue"]();
}, xK:function (col, type, order) {
	order = (order || "asc").toLowerCase();
	type = (type || this.fldSort[col]);
	col = col || 0;
	if (this.gY()) {
		this.sT(col, type, order);
	} else {
		var iC = {};
		var aaz = this.cellType[col];
		var agS = "getValue";
		if (aaz == "link") {
			agS = "getContent";
		}
		if (aaz == "dhxCalendar" || aaz == "dhxCalendarA") {
			agS = "getDate";
		}
		for (var i = 0; i < this.aD.length; i++) {
			iC[this.aD[i].idd] = this._get_cell_value(this.aD[i], col, agS);
		}
		this.vP(col, type, order, iC);
	}
	this.callEvent("onAfterSorting", [col, type, order]);
}, aeo:function (col, type, order, iC, s) {
	var sort = "sort";
	if (this.agg) {
		s["stablesort"] = this.am.stablesort;
		sort = "stablesort";
	}
	if (type.length > 4) {
		type = window[type];
	}
	if (type == "cus") {
		var cstr = this._customSorts[col];
		s[sort](function (a, b) {
			return cstr(iC[a.idd], iC[b.idd], order, a.idd, b.idd);
		});
	} else {
		if (typeof (type) == "function") {
			s[sort](function (a, b) {
				return type(iC[a.idd], iC[b.idd], order, a.idd, b.idd);
			});
		} else {
			if (type == "str") {
				s[sort](function (a, b) {
					if (order == "asc") {
						return iC[a.idd] > iC[b.idd] ? 1 : -1;
					} else {
						return iC[a.idd] < iC[b.idd] ? 1 : -1;
					}
				});
			} else {
				if (type == "int") {
					s[sort](function (a, b) {
						var qe = parseFloat(iC[a.idd]);
						qe = isNaN(qe) ? -99999999999999 : qe;
						var sm = parseFloat(iC[b.idd]);
						sm = isNaN(sm) ? -99999999999999 : sm;
						if (order == "asc") {
							return qe - sm;
						} else {
							return sm - qe;
						}
					});
				} else {
					if (type == "date") {
						s[sort](function (a, b) {
							var qe = Date.parse(iC[a.idd]) || (Date.parse("01/01/1900"));
							var sm = Date.parse(iC[b.idd]) || (Date.parse("01/01/1900"));
							if (order == "asc") {
								return qe - sm;
							} else {
								return sm - qe;
							}
						});
					}
				}
			}
		}
	}
}, vP:function (col, type, order, iC) {
	this.aeo(col, type, order, iC, this.aD);
	this._reset_view();
	this.callEvent("onGridReconstructed", []);
}, _reset_view:function (Ch) {
	if (!this.obj.rows[0]) {
		return;
	}
	var tb = this.obj.rows[0].parentNode;
	var tr = tb.removeChild(tb.childNodes[0], true);
	if (cn) {
		for (var i = tb.parentNode.childNodes.length - 1; i >= 0; i--) {
			if (tb.parentNode.childNodes[i].tagName == "TR") {
				tb.parentNode.removeChild(tb.parentNode.childNodes[i], true);
			}
		}
	} else {
		if (_isIE) {
			for (var i = tb.childNodes.length - 1; i >= 0; i--) {
				tb.childNodes[i].removeNode(true);
			}
		} else {
			tb.innerHTML = "";
		}
	}
	tb.appendChild(tr);
	this.am = dhtmlxArray();
	if (this.agg) {
		this.enableStableSorting(true);
	}
	this._fillers = this.undefined;
	if (!Ch) {
		if (_isIE && this.ahK) {
			this.render_dataset();
		} else {
			this.render_dataset();
		}
	}
}, deleteRow:function (bO, node) {
	if (!node) {
		node = this.dz(bO);
	}
	if (!node) {
		return;
	}
	this.editStop();
	if (!this.nh) {
		if (this.callEvent("onBeforeRowDeleted", [bO]) == false) {
			return false;
		}
	}
	var qc = 0;
	if (this.cellType.bP("tree") != -1 && !this.nh) {
		qc = this._h2.get[bO].parent.id;
		this.yE(node);
	} else {
		if (node.parentNode) {
			node.parentNode.removeChild(node);
		}
		var ind = this.am.bP(node);
		if (ind != -1) {
			this.am.hd(ind);
		}
		for (var i = 0; i < this.aD.length; i++) {
			if (this.aD[i] && this.aD[i].idd == bO) {
				this.aD.hd(i);
				ind = i;
				break;
			}
		}
	}
	this.bj[bO] = null;
	for (var i = 0; i < this.bY.length; i++) {
		if (this.bY[i].idd == bO) {
			this.bY.hd(i);
		}
	}
	if (this.ahK) {
		for (var i = 0; i < this._fillers.length; i++) {
			var f = this._fillers[i];
			if (!f) {
				continue;
			}
			if (f[0] >= ind) {
				f[0] = f[0] - 1;
			} else {
				if (f[1] >= ind) {
					f[1] = f[1] - 1;
				}
			}
		}
		this._update_srnd_view();
	}
	if (this.aW) {
		this.changePage();
	}
	if (!this.nh) {
		this.callEvent("onAfterRowDeleted", [bO, qc]);
	}
	this.callEvent("onGridReconstructed", []);
	if (this.abK) {
		this.setSizes();
	}
	return true;
}, ait:function (oO, text, ind) {
	if (ind == -1 || typeof ind == "undefined") {
		ind = this.aD.length;
	}
	if (typeof text == "string") {
		text = text.split(this.gX);
	}
	var row = this.uO(oO);
	row._attrs = {};
	for (var j = 0; j < row.childNodes.length; j++) {
		row.childNodes[j]._attrs = {};
	}
	this.bj[row.idd] = row;
	if (this._h2) {
		this._h2.get[row.idd].buff = row;
	}
	this.VQ(row, text);
	this.jQ(row);
	if (this.WX) {
		this.WX = false;
		return this.bj[row.idd] = row;
	}
	if (this.aW) {
		this.aD.ml(ind, row);
		this.bj[row.idd] = row;
		return row;
	}
	if (this._fillers) {
		this.am.ml(ind, null);
		this.aD.ml(ind, row);
		if (this.aC) {
			this.aC.am.ml(ind, null);
		}
		this.bj[row.idd] = row;
		var found = false;
		for (var i = 0; i < this._fillers.length; i++) {
			var f = this._fillers[i];
			if (f && f[0] <= ind && (f[0] + f[1]) >= ind) {
				f[1] = f[1] + 1;
				f[2].firstChild.style.height = parseInt(f[2].firstChild.style.height) + this.ig + "px";
				found = true;
				if (this.aC) {
					this.aC._fillers[i][1]++;
				}
			}
			if (f && f[0] > ind) {
				f[0] = f[0] + 1;
				if (this.aC) {
					this.aC._fillers[i][0]++;
				}
			}
		}
		if (!found) {
			this._fillers.push(this._add_filler(ind, 1, (ind == 0 ? {parentNode:this.obj.rows[0].parentNode, nextSibling:(this.am[1])} : this.am[ind - 1])));
		}
		return row;
	}
	this.aD.ml(ind, row);
	return this._insertRowAt(row, ind);
}, hY:function (oO, text, ind) {
	var r = this.ait(oO, text, ind);
	if (!this.fX) {
		this.callEvent("onRowAdded", [oO]);
	}
	if (this.aW) {
		this.changePage(this.ew);
	}
	if (this.ahK) {
		this._update_srnd_view();
	}
	r.adM = true;
	if (this.abK) {
		this.setSizes();
	}
	this.callEvent("onGridReconstructed", []);
	return r;
}, _insertRowAt:function (r, ind, Ch) {
	this.bj[r.idd] = r;
	if (this.WX) {
		this.WX = false;
		return r;
	}
	if ((ind < 0) || ((!ind) && (parseInt(ind) !== 0))) {
		ind = this.am.length;
	} else {
		if (ind > this.am.length) {
			ind = this.am.length;
		}
	}
	if (this.hC) {
		if ((this.Cw ? this.sS(r.idd) : ind) % 2 == 1) {
			r.className += " " + this.iI + (this.Vh ? (" " + this.iI + "_" + this.sS(r.idd)) : "");
		} else {
			r.className += " " + this.hC + (this.Vh ? (" " + this.hC + "_" + this.sS(r.idd)) : "");
		}
	}
	if (!Ch) {
		if ((ind == (this.obj.rows.length - 1)) || (!this.am[ind])) {
			if (cn) {
				this.obj.appendChild(r);
			} else {
				this.obj.firstChild.appendChild(r);
			}
		} else {
			this.am[ind].parentNode.insertBefore(r, this.am[ind]);
		}
	}
	this.am.ml(ind, r);
	return r;
}, dz:function (id) {
	var row = this.bj[id];
	if (row) {
		if (row.tagName != "TR") {
			for (var i = 0; i < this.aD.length; i++) {
				if (this.aD[i] && this.aD[i].idd == id) {
					return this.render_row(i);
				}
			}
			if (this._h2) {
				return this.render_row(null, row.idd);
			}
		}
		return row;
	}
	return null;
}, apX:function (bO, col) {
	return this.cells(bO, col);
}, cells:function (bO, col) {
	if (arguments.length == 0) {
		return this.cells4(this.cell);
	} else {
		var c = this.dz(bO);
	}
	var cell = (c.bq ? c.childNodes[c.bq[col]] : c.childNodes[col]);
	return this.cells4(cell);
}, amP:function (acF, col) {
	return this.cells2(acF, col);
}, cells2:function (acF, col) {
	var c = this.render_row(acF);
	var cell = (c.bq ? c.childNodes[c.bq[col]] : c.childNodes[col]);
	return this.cells4(cell);
}, cells3:function (row, col) {
	var cell = (row.bq ? row.childNodes[row.bq[col]] : row.childNodes[col]);
	return this.cells4(cell);
}, cells4:function (cell) {
	var type = window["eXcell_" + (cell.zk || this.cellType[cell._cellIndex])];
	if (type) {
		return new type(cell);
	}
}, adH:function (cell, type) {
	var type = type || (cell.zk || this.cellType[cell._cellIndex]);
	if (!this.XC[type]) {
		if (!window["eXcell_" + type]) {
			var tex = eXcell_ro;
		} else {
			var tex = window["eXcell_" + type];
		}
		this.XC[type] = new tex(cell);
	}
	this.XC[type].cell = cell;
	return this.XC[type];
}, dma:function (mode) {
	if (!this.XC) {
		this.XC = {};
	}
	if (mode && !this.abp) {
		this.abp = this.cells4;
		this.cells4 = this.adH;
	} else {
		if (!mode && this.abp) {
			this.cells4 = this.abp;
			this.abp = null;
		}
	}
}, iD:function () {
	return this.aD.length;
}, enableEditTabOnly:function (mode) {
	if (arguments.length > 0) {
		this.smartTabOrder = ap(mode);
	} else {
		this.smartTabOrder = true;
	}
}, setExternalTabOrder:function (start, end) {
	var grid = this;
	this.tabStart = (typeof (start) == "object") ? start : document.getElementById(start);
	this.tabStart.onkeydown = function (e) {
		var ev = (e || window.event);
		if (ev.keyCode == 9) {
			ev.cancelBubble = true;
			grid.eQ(0, 0, 0, 0, 1);
			if (grid.smartTabOrder && grid.cells2(0, 0).isDisabled()) {
				grid.zf["k9_0_0"].call(grid);
			}
			this.blur();
			return false;
		}
	};
	if (cU) {
		this.tabStart.onkeypress = this.tabStart.onkeydown;
	}
	this.tabEnd = (typeof (end) == "object") ? end : document.getElementById(end);
	this.tabEnd.onkeydown = this.tabEnd.onkeypress = function (e) {
		var ev = (e || window.event);
		if ((ev.keyCode == 9) && ev.shiftKey) {
			ev.cancelBubble = true;
			grid.eQ((grid.iD() - 1), (grid.So() - 1), 0, 0, 1);
			if (grid.smartTabOrder && grid.cells2((grid.iD() - 1), (grid.So() - 1)).isDisabled()) {
				grid.zf["k9_0_1"].call(grid);
			}
			this.blur();
			return false;
		}
	};
	if (cU) {
		this.tabEnd.onkeypress = this.tabEnd.onkeydown;
	}
}, uid:function () {
	if (!this._ui_seed) {
		this._ui_seed = (new Date()).valueOf();
	}
	return this._ui_seed++;
}, clearAndLoad:function () {
	var t = this._pgn_skin;
	this._pgn_skin = null;
	this.clearAll();
	this._pgn_skin = t;
	this.load.apply(this, arguments);
}, ajA:function () {
	if (this.aW) {
		var start = (this.ew - 1) * this.cu;
		return [this.ew, start, Math.min(start + this.cu, this.aD.length), this.aD.length];
	}
	return [Math.floor(this.HF.scrollTop / this.ig), Math.ceil(parseInt(this.HF.offsetHeight) / this.ig), this.aD.length];
}};
(function () {
	function direct_set(name, value) {
		this[name] = value;
	}
	function direct_call(name, value) {
		this[name].call(this, value);
	}
	function joined_call(name, value) {
		this[name].call(this, value.join(this.gX));
	}
	function set_options(name, value) {
		for (var i = 0; i < value.length; i++) {
			if (typeof value[i] == "object") {
				var combo = this.cf(i);
				for (var Gb in value[i]) {
					combo.eT(Gb, value[i][Gb]);
				}
			}
		}
	}
	function header_set(name, value, obj) {
		var rows = 1;
		var header = [];
		function add(i, j, value) {
			if (!header[j]) {
				header[j] = [];
			}
			if (typeof value == "object") {
				value.toString = function () {
					return this.text;
				};
			}
			header[j][i] = value;
		}
		for (var i = 0; i < value.length; i++) {
			if (typeof (value[i]) == "object" && value[i].length) {
				for (var j = 0; j < value[i].length; j++) {
					add(i, j, value[i][j]);
				}
			} else {
				add(i, 0, value[i]);
			}
		}
		for (var i = 0; i < header.length; i++) {
			for (var j = 0; j < header[0].length; j++) {
				var h = header[i][j];
				header[i][j] = (h || "").toString() || "&nbsp;";
				if (h && h.colspan) {
					for (var k = 1; k < h.colspan; k++) {
						add(j + k, i, "#cspan");
					}
				}
				if (h && h.rowspan) {
					for (var k = 1; k < h.rowspan; k++) {
						add(j, i + k, "#rspan");
					}
				}
			}
		}
		this.setHeader(header[0]);
		for (var i = 1; i < header.length; i++) {
			this.attachHeader(header[i]);
		}
	}
	var columns_map = [{name:"label", def:"&nbsp;", operation:"setHeader", type:header_set}, {name:"id", def:"", operation:"columnIds", type:direct_set}, {name:"width", def:"*", operation:"setInitWidths", type:joined_call}, {name:"align", def:"left", operation:"cellAlign", type:direct_set}, {name:"valign", def:"middle", operation:"cellVAlign", type:direct_set}, {name:"sort", def:"na", operation:"fldSort", type:direct_set}, {name:"type", def:"ro", operation:"setColTypes", type:joined_call}, {name:"options", def:"", operation:"", type:set_options}];
	dhtmlx.extend_api("dhtmlXGridObject", {ahY:function (obj) {
		return [obj.parent];
	}, image_path:"setImagePath", columns:"columns", rows:"rows", headers:"headers", skin:"setSkin", smart_rendering:"enableSmartRendering", css:"enableAlterCss", auto_height:"enableAutoHeight", save_hidden:"enableAutoHiddenColumnsSaving", save_cookie:"enableAutoSaving", save_size:"enableAutoSizeSaving", auto_width:"enableAutoWidth", block_selection:"enableBlockSelection", csv_id:"enableCSVAutoID", csv_header:"enableCSVHeader", cell_ids:"enableCellIds", colspan:"enableColSpan", column_move:"enableColumnMove", context_menu:"enableContextMenu", distributed:"enableDistributedParsing", drag:"enableDragAndDrop", drag_order:"enableDragOrder", tabulation:"enableEditTabOnly", header_images:"enableHeaderImages", header_menu:"enableHeaderMenu", keymap:"enableKeyboardSupport", mouse_navigation:"enableLightMouseNavigation", markers:"enableMarkedCells", math_editing:"enableMathEditing", math_serialization:"enableMathSerialization", drag_copy:"enableMercyDrag", multiline:"enableMultiline", multiselect:"enableMultiselect", save_column_order:"enableOrderSaving", hover:"enableRowsHover", rowspan:"enableRowspan", smart:"enableSmartRendering", save_sorting:"enableSortingSaving", stable_sorting:"enableStableSorting", undo:"enableUndoRedo", csv_cell:"setCSVDelimiter", date_format:"setDateFormat", drag_behavior:"setDragBehavior", editable:"setEditable", without_header:"setNoHeader", submit_changed:"submitOnlyChanged", submit_serialization:"submitSerialization", submit_selected:"submitOnlySelected", submit_id:"submitOnlyRowID", xml:"load"}, {columns:function (obj) {
		for (var j = 0; j < columns_map.length; j++) {
			var settings = [];
			for (var i = 0; i < obj.length; i++) {
				settings[i] = obj[i][columns_map[j].name] || columns_map[j].def;
			}
			var type = columns_map[j].type || direct_call;
			type.call(this, columns_map[j].operation, settings, obj);
		}
		this.init();
	}, rows:function (obj) {
	}, headers:function (obj) {
		for (var i = 0; i < obj.length; i++) {
			this.attachHeader(obj[i]);
		}
	}});
})();
dhtmlXGridObject.prototype._dp_init = function (dp) {
	dp.attachEvent("insertCallback", function (upd, id) {
		if (this.obj._h2) {
			this.obj.hY(id, row, null, parent);
		} else {
			this.obj.hY(id, [], 0);
		}
		var row = this.obj.dz(id);
		if (row) {
			this.obj._process_xml_row(row, upd.firstChild);
			this.obj.jQ(row);
		}
	});
	dp.attachEvent("updateCallback", function (upd, id) {
		var row = this.obj.dz(id);
		if (row) {
			this.obj._process_xml_row(row, upd.firstChild);
			this.obj.jQ(row);
		}
	});
	dp.attachEvent("deleteCallback", function (upd, id) {
		this.obj.setUserData(id, this.action_param, "true_deleted");
		this.obj.deleteRow(id);
	});
	dp._methods = ["setRowTextStyle", "setCellTextStyle", "changeRowId", "deleteRow"];
	this.attachEvent("onEditCell", function (state, id, index) {
		if (dp._columns && !dp._columns[index]) {
			return true;
		}
		var cell = this.cells(id, index);
		if (state == 1) {
			if (cell.wI()) {
				dp.setUpdated(id, true);
			}
		} else {
			if (state == 2) {
				if (cell.hy()) {
					dp.setUpdated(id, true);
				}
			}
		}
		return true;
	});
	this.attachEvent("onRowPaste", function (id) {
		dp.setUpdated(id, true);
	});
	this.attachEvent("onRowIdChange", function (id, newid) {
		var ind = dp.iv(id);
		if (ind < dp.bE.length) {
			dp.bE[ind] = newid;
		}
	});
	this.attachEvent("onSelectStateChanged", function (cq) {
		if (dp.cJ == "row") {
			dp.sendData();
		}
		return true;
	});
	this.attachEvent("onEnter", function (cq, akG) {
		if (dp.cJ == "row") {
			dp.sendData();
		}
		return true;
	});
	this.attachEvent("onBeforeRowDeleted", function (cq) {
		if (!this.bj[cq]) {
			return true;
		}
		if (this.fX && dp.dnd) {
			window.setTimeout(function () {
				dp.setUpdated(cq, true);
			}, 1);
			return true;
		}
		var z = dp.YA(cq);
		if (this._h2) {
			this._h2.so(cq, function (el) {
				dp.setUpdated(el.id, false);
				dp.markRow(el.id, true, "deleted");
			}, this);
		}
		if (z == "inserted") {
			dp.set_invalid(cq, false);
			dp.setUpdated(cq, false);
			return true;
		}
		if (z == "deleted") {
			return false;
		}
		if (z == "true_deleted") {
			dp.setUpdated(cq, false);
			return true;
		}
		dp.setUpdated(cq, true, "deleted");
		return false;
	});
	this.attachEvent("onRowAdded", function (cq) {
		if (this.fX && dp.dnd) {
			return true;
		}
		dp.setUpdated(cq, true, "inserted");
		return true;
	});
	dp.fD = function (cq, apG) {
		var data = [];
		data["gr_id"] = cq;
		if (this.obj.gY()) {
			data["gr_pid"] = this.obj.getParentId(cq);
		}
		var r = this.obj.dz(cq);
		for (var i = 0; i < this.obj.gA; i++) {
			if (this.obj._c_order) {
				var i_c = this.obj._c_order[i];
			} else {
				var i_c = i;
			}
			var c = this.obj.cells(r.idd, i);
			if (this._changed && !c.hy()) {
				continue;
			}
			if (this.iO) {
				data[this.obj.getColumnId(i)] = c.getValue();
			} else {
				data["c" + i_c] = c.getValue();
			}
		}
		var udata = this.obj.bH[cq];
		if (udata) {
			for (var j = 0; j < udata.kk.length; j++) {
				if (udata.kk[j].indexOf("__") != 0) {
					data[udata.kk[j]] = udata.values[j];
				}
			}
		}
		var udata = this.obj.bH["gridglobaluserdata"];
		if (udata) {
			for (var j = 0; j < udata.kk.length; j++) {
				data[udata.kk[j]] = udata.values[j];
			}
		}
		return data;
	};
	dp._clearUpdateFlag = function (cq) {
		var row = this.obj.dz(cq);
		if (row) {
			for (var j = 0; j < this.obj.gA; j++) {
				this.obj.cells(cq, j).cell.hy = false;
			}
		}
	};
	dp.aZ = function (cq) {
		var valid = true;
		var c_invalid = [];
		for (var i = 0; i < this.obj.gA; i++) {
			if (this.az[i]) {
				var res = this.az[i].call(this.obj, this.obj.cells(cq, i).getValue(), cq, i);
				if (typeof res == "string") {
					this.messages.push(res);
					valid = false;
				} else {
					valid &= res;
					c_invalid[i] = !res;
				}
			}
		}
		if (!valid) {
			this.set_invalid(cq, "invalid", c_invalid);
			this.setUpdated(cq, false);
		}
		return valid;
	};
};

