
dhtmlXGridObject.prototype.GF = function (column, value, iW) {
	if (this.gY()) {
		return this.filterTreeBy(column, value, iW);
	}
	if (this._f_rowsBuffer) {
		if (!iW) {
			this.aD = dhtmlxArray([].concat(this._f_rowsBuffer));
			if (this.aC) {
				this.aC.aD = this.aD;
			}
		}
	} else {
		this._f_rowsBuffer = [].concat(this.aD);
	}
	if (!this.aD.length) {
		return;
	}
	var d = true;
	this.dma(true);
	if (typeof (column) == "object") {
		for (var j = 0; j < value.length; j++) {
			this.WZ(column[j], value[j]);
		}
	} else {
		this.WZ(column, value);
	}
	this.dma(false);
	if (this.aW && this.aD.length / this.cu < (this.ew - 1)) {
		this.changePage(0);
	}
	this._reset_view();
	this.callEvent("onGridReconstructed", []);
};
dhtmlXGridObject.prototype.WZ = function (column, value) {
	if (value == "") {
		return;
	}
	var d = true;
	if (typeof (value) == "function") {
		d = false;
	} else {
		value = (value || "").toString().toLowerCase();
	}
	if (!this.aD.length) {
		return;
	}
	for (var i = this.aD.length - 1; i >= 0; i--) {
		if (d ? (this._get_cell_value(this.aD[i], column).toString().toLowerCase().indexOf(value) == -1) : (!value(this._get_cell_value(this.aD[i], column), this.aD[i].idd))) {
			this.aD.splice(i, 1);
		}
	}
};
dhtmlXGridObject.prototype.getFilterElement = function (index) {
	if (!this.filters) {
		return;
	}
	for (var i = 0; i < this.filters.length; i++) {
		if (this.filters[i][1] == index) {
			return (this.filters[i][0].combo || this.filters[i][0]);
		}
	}
	return null;
};
dhtmlXGridObject.prototype.Ii = function (column) {
	var value = this.callEvent("onCollectValues", [column]);
	if (value !== true) {
		return value;
	}
	if (this.gY()) {
		return this.collectTreeValues(column);
	}
	this.dma(true);
	column = this.abc ? this.abc[column] : column;
	var c = {};
	var f = [];
	this._build_m_order();
	var col = this._f_rowsBuffer || this.aD;
	for (var i = 0; i < col.length; i++) {
		var val = this._get_cell_value(col[i], column);
		if (val && (!col[i].bq || col[i].bq[column] != col[i].bq[column - 1])) {
			c[val] = true;
		}
	}
	this.dma(false);
	var ND = this.combos[column];
	for (d in c) {
		if (c[d] === true) {
			f.push(ND ? (ND.get(d) || d) : d);
		}
	}
	return f.sort();
};
dhtmlXGridObject.prototype._build_m_order = function () {
	if (this._c_order) {
		this.abc = [];
		for (var i = 0; i < this._c_order.length; i++) {
			this.abc[this._c_order[i]] = i;
		}
	}
};
dhtmlXGridObject.prototype.EJ = function () {
	var a = [];
	var b = [];
	this._build_m_order();
	for (var i = 0; i < this.filters.length; i++) {
		var ind = this.abc ? this.abc[this.filters[i][1]] : this.filters[i][1];
		b.push(ind);
		var val = this.filters[i][0]._filter ? this.filters[i][0]._filter() : this.filters[i][0].value;
		var ND;
		if (typeof val != "function" && (ND = this.combos[ind])) {
			ind = ND.values.bP(val);
			val = (ind == -1) ? val : ND.kk[ind];
		}
		a.push(val);
	}
	if (!this.callEvent("onFilterStart", [b, a])) {
		return;
	}
	this.GF(b, a);
	if (this.hC) {
		this._fixAlterCss();
	}
	this.callEvent("onFilterEnd", [this.filters]);
};
dhtmlXGridObject.prototype.Hj = function (id, column, iW) {
	if (!this.filters) {
		this.filters = [];
	}
	if (typeof (id) != "object") {
		id = document.getElementById(id);
	}
	if (!id) {
		return;
	}
	var self = this;
	if (!id.style.width) {
		id.style.width = "90%";
	}
	if (id.tagName == "SELECT") {
		this.filters.push([id, column]);
		this.AU(id, column);
		id.onchange = function () {
			self.EJ();
		};
		if (_isIE) {
			id.style.marginTop = "1px";
		}
		this.attachEvent("onEditCell", function (stage, a, ind) {
			this._build_m_order();
			if (stage == 2 && this.filters && (this.abc ? (ind == this.abc[column]) : (ind == column))) {
				this.AU(id, column);
			}
			return true;
		});
	} else {
		if (id.tagName == "INPUT") {
			this.filters.push([id, column]);
			id.value = "";
			id.onkeydown = function () {
				if (this.adm) {
					window.clearTimeout(this.adm);
				}
				this.adm = window.setTimeout(function () {
					if (id.value != id.uM) {
						self.EJ();
						id.uM = id.value;
					}
				}, 500);
			};
		} else {
			if (id.tagName == "DIV" && id.className == "combo") {
				this.filters.push([id, column]);
				id.style.padding = "0px";
				id.style.margin = "0px";
				if (!window.fe) {
					window.fe = this.eg;
				}
				var z = new dhtmlXCombo(id, "_filter", "90%");
				z.filterSelfA = z.Qm;
				z.Qm = function () {
					if (this.Nn() == 0) {
						this.nQ("");
					}
					this.filterSelfA.apply(this, arguments);
					this.du[0].hide(false);
				};
				z.fF(true);
				id.combo = z;
				id.value = "";
				this.Dg(id, column);
				z.attachEvent("onChange", function () {
					id.value = z.vL();
					self.EJ();
				});
			}
		}
	}
	if (id.parentNode) {
		id.parentNode.className += " filter";
	}
	this.tJ();
};
dhtmlXGridObject.prototype.OD = function (value, MT, count) {
	var res = new Array();
	value = value.toString().toLowerCase();
	if (typeof count != "number") {
		count = count ? 1 : 0;
	}
	if (!this.aD.length) {
		return res;
	}
	for (var i = (MT || 0); i < this.gA; i++) {
		if (this._h2) {
			this._h2.so(0, function (el) {
				if (count && res.length == count) {
					return res;
				}
				if (this._get_cell_value(el.buff, i).toString().toLowerCase().indexOf(value) != -1) {
					res.push([el.id, i]);
				}
			}, this);
		} else {
			for (var j = 0; j < this.aD.length; j++) {
				if (this._get_cell_value(this.aD[j], i).toString().toLowerCase().indexOf(value) != -1) {
					res.push([this.aD[j].idd, i]);
					if (count && res.length == count) {
						return res;
					}
				}
			}
		}
		if (typeof (MT) != "undefined") {
			return res;
		}
	}
	return res;
};
dhtmlXGridObject.prototype.abm = function (id, column) {
	if (typeof (id) != "object") {
		id = document.getElementById(id);
	}
	if (!id) {
		return;
	}
	var self = this;
	if (id.tagName == "INPUT") {
		id.onkeypress = function () {
			if (this.adm) {
				window.clearTimeout(this.adm);
			}
			this.adm = window.setTimeout(function () {
				if (id.value == "") {
					return;
				}
				var z = self.OD(id.value, column, true);
				if (z.length) {
					if (self._h2) {
						self.hx(z[0][0]);
					}
					self.eQ(self.getRowIndex(z[0][0]), (column || 0));
				}
			}, 500);
		};
	}
	if (id.parentNode) {
		id.parentNode.className += " filter";
	}
};
dhtmlXGridObject.prototype.AU = function (t, c) {
	var l = this.Ii(c);
	var v = t.value;
	t.innerHTML = "";
	t.options[0] = new Option("", "");
	var f = this.afI ? this.afI[c] : null;
	for (var i = 0; i < l.length; i++) {
		t.options[t.options.length] = new Option(f ? f(l[i]) : l[i], l[i]);
	}
	t.value = v;
};
dhtmlXGridObject.prototype.setSelectFilterLabel = function (ind, fun) {
	if (!this.afI) {
		this.afI = [];
	}
	this.afI[ind] = fun;
};
dhtmlXGridObject.prototype.Dg = function (t, c) {
	var l = this.Ii(c);
	t.combo.clearAll();
	t.combo.ht(false);
	t.combo.addOption("", "&nbsp;");
	for (var i = 0; i < l.length; i++) {
		t.combo.addOption(l[i], l[i]);
	}
	t.combo.ht(true);
};
dhtmlXGridObject.prototype.RQ = function () {
	if (!this.filters) {
		return;
	}
	for (var i = 0; i < this.filters.length; i++) {
		switch (this.filters[i][0].tagName.toLowerCase()) {
		  case "input":
			break;
		  case "select":
			this.AU.apply(this, this.filters[i]);
			break;
		  case "div":
			this.Dg.apply(this, this.filters[i]);
			break;
		}
	}
};
dhtmlXGridObject.prototype.tJ = function (fl, code) {
	this.attachEvent("onXLE", this.RQ);
	this.attachEvent("onRowCreated", function (id, r) {
		if (this._f_rowsBuffer) {
			for (var i = 0; i < this._f_rowsBuffer.length; i++) {
				if (this._f_rowsBuffer[i].idd == id) {
					return this._f_rowsBuffer[i] = r;
				}
			}
		}
	});
	this.attachEvent("onClearAll", function () {
		this._f_rowsBuffer = null;
		if (!this.hdr.rows.length) {
			this.filters = [];
		}
	});
	if (window.dhtmlXCombo) {
		this.attachEvent("onScroll", dhtmlXCombo.prototype.pl);
	}
	this.tJ = function () {
	};
};
dhtmlXGridObject.prototype._in_header_text_filter = function (t, i) {
	t.innerHTML = "<input type='text' style='width:90%;font-size:8pt;font-family:Tahoma;-moz-user-select:text;'>";
	t.onclick = t.onmousedown = function (e) {
		(e || event).cancelBubble = true;
		return true;
	};
	t.onselectstart = function () {
		return (event.cancelBubble = true);
	};
	this.Hj(t.firstChild, i);
};
dhtmlXGridObject.prototype._in_header_text_filter_inc = function (t, i) {
	t.innerHTML = "<input type='text' style='width:90%;font-size:8pt;font-family:Tahoma;-moz-user-select:text;'>";
	t.onclick = t.onmousedown = function (e) {
		(e || event).cancelBubble = true;
		return true;
	};
	t.onselectstart = function () {
		return (event.cancelBubble = true);
	};
	this.Hj(t.firstChild, i);
	t.firstChild._filter = function () {
		return function (val) {
			return (val.toString().toLowerCase().indexOf(t.firstChild.value.toLowerCase()) == 0);
		};
	};
	this.tJ();
};
dhtmlXGridObject.prototype._in_header_select_filter = function (t, i) {
	t.innerHTML = "<select style='width:90%;font-size:8pt;font-family:Tahoma;'></select>";
	t.onclick = function (e) {
		(e || event).cancelBubble = true;
		return false;
	};
	this.Hj(t.firstChild, i);
};
dhtmlXGridObject.prototype._in_header_select_filter_strict = function (t, i) {
	t.innerHTML = "<select style='width:90%;font-size:8pt;font-family:Tahoma;'></select>";
	t.onclick = function (e) {
		(e || event).cancelBubble = true;
		return false;
	};
	this.Hj(t.firstChild, i);
	t.firstChild._filter = function () {
		return function (val) {
			if (t.firstChild.value.toLowerCase() == "") {
				return true;
			}
			return (val.toString().toLowerCase() == t.firstChild.value.toLowerCase());
		};
	};
	this.tJ();
};
dhtmlXGridObject.prototype._in_header_combo_filter = function (t, i) {
	t.innerHTML = "<div style='width:100%;padding-left:2px;overflow:hidden;font-size:8pt;font-family:Tahoma;-moz-user-select:text;' class='combo'></div>";
	t.onselectstart = function () {
		return (event.cancelBubble = true);
	};
	t.onclick = t.onmousedown = function (e) {
		(e || event).cancelBubble = true;
		return true;
	};
	this.Hj(t.firstChild, i);
};
dhtmlXGridObject.prototype._in_header_text_search = function (t, i) {
	t.innerHTML = "<input type='text' style='width:90%;font-size:8pt;font-family:Tahoma;-moz-user-select:text;'>";
	t.onclick = t.onmousedown = function (e) {
		(e || event).cancelBubble = true;
		return true;
	};
	t.onselectstart = function () {
		return (event.cancelBubble = true);
	};
	this.abm(t.firstChild, i);
};
dhtmlXGridObject.prototype._in_header_numeric_filter = function (t, i) {
	this._in_header_text_filter.call(this, t, i);
	t.firstChild._filter = function () {
		var v = this.value;
		var r;
		var op = "==";
		var num = parseFloat(v.replace("=", ""));
		var num2 = null;
		if (v) {
			if (v.indexOf("..") != -1) {
				v = v.split("..");
				num = parseFloat(v[0]);
				num2 = parseFloat(v[1]);
				return function (v) {
					if (v >= num && v <= num2) {
						return true;
					}
					return false;
				};
			}
			r = v.match(/>|>=|<=|</);
			if (r) {
				op = r[0];
				num = parseFloat(v.replace(op, ""));
			}
			return Function("v", " if (v " + op + " " + num + " )return true;return false;");
		}
	};
};
dhtmlXGridObject.prototype._in_header_master_checkbox = function (t, i, c) {
	t.innerHTML = c[0] + "<input type='checkbox' />" + c[1];
	var self = this;
	t.getElementsByTagName("input")[0].onclick = function (e) {
		self._build_m_order();
		var j = self.abc ? self.abc[i] : i;
		var val = this.checked ? 1 : 0;

		self.forEachRowA(function (id) {
			var c = this.cells(id, j);
			if (c.wI()) {
				if (c.getValue() != val) {
					c.setValue(val);
					this.callEvent("onCheckbox", [
						c.cell.parentNode.idd,
						c.cell._cellIndex,
						(val != '1')
					]);
				}
			}
			this.callEvent("onEditCell", [1, id, j, val]);
		});
		(e || event).cancelBubble = true;
	};
};
dhtmlXGridObject.prototype._in_header_stat_total = function (t, i, c) {
	var calck = function () {
		var AG = 0;
		var ii = this._c_order ? this._c_order[i] : i;
		for (var j = 0; j < this.aD.length; j++) {
			var v = parseFloat(this._get_cell_value(this.aD[j], ii));
			AG += isNaN(v) ? 0 : v;
		}
		return this._maskArr[ii] ? this.PH(AG, ii) : (Math.round(AG * 100) / 100);
	};
	this.Ru(t, calck, i, c, c);
};
dhtmlXGridObject.prototype._in_header_stat_multi_total = function (t, i, c) {
	var cols = c[1].split(":");
	c[1] = "";
	for (var k = 0; k < cols.length; k++) {
		cols[k] = parseInt(cols[k]);
	}
	var calck = function () {
		var AG = 0;
		for (var j = 0; j < this.aD.length; j++) {
			var v = 1;
			for (var k = 0; k < cols.length; k++) {
				v *= parseFloat(this._get_cell_value(this.aD[j], cols[k]));
			}
			AG += isNaN(v) ? 0 : v;
		}
		return this._maskArr[i] ? this.PH(AG, i) : (Math.round(AG * 100) / 100);
	};
	var track = [];
	for (var i = 0; i < cols.length; i++) {
		track[cols[i]] = true;
	}
	this.Ru(t, calck, track, c, c);
};
dhtmlXGridObject.prototype._in_header_stat_max = function (t, i, c) {
	var calck = function () {
		var AG = -999999999;
		if (this.iD() == 0) {
			return "&nbsp;";
		}
		for (var j = 0; j < this.aD.length; j++) {
			AG = Math.max(AG, parseFloat(this._get_cell_value(this.aD[j], i)));
		}
		return this._maskArr[i] ? this.PH(AG, i) : AG;
	};
	this.Ru(t, calck, i, c);
};
dhtmlXGridObject.prototype._in_header_stat_min = function (t, i, c) {
	var calck = function () {
		var AG = 999999999;
		if (this.iD() == 0) {
			return "&nbsp;";
		}
		for (var j = 0; j < this.aD.length; j++) {
			AG = Math.min(AG, parseFloat(this._get_cell_value(this.aD[j], i)));
		}
		return this._maskArr[i] ? this.PH(AG, i) : AG;
	};
	this.Ru(t, calck, i, c);
};
dhtmlXGridObject.prototype._in_header_stat_average = function (t, i, c) {
	var calck = function () {
		var AG = 0;
		var count = 0;
		if (this.iD() == 0) {
			return "&nbsp;";
		}
		for (var j = 0; j < this.aD.length; j++) {
			var v = parseFloat(this._get_cell_value(this.aD[j], i));
			AG += isNaN(v) ? 0 : v;
			count++;
		}
		return this._maskArr[i] ? this.PH(AG / count, i) : (Math.round(AG / count * 100) / 100);
	};
	this.Ru(t, calck, i, c);
};
dhtmlXGridObject.prototype._in_header_stat_count = function (t, i, c) {
	var calck = function () {
		return this.iD();
	};
	this.Ru(t, calck, i, c);
};
dhtmlXGridObject.prototype.Ru = function (t, calck, i, c) {
	var that = this;
	var f = function () {
		this.dma(true);
		t.innerHTML = (c[0] ? c[0] : "") + calck.call(this) + (c[1] ? c[1] : "");
		this.dma(false);
		this.callEvent("onStatReady", []);
	};
	if (!this.afh) {
		this.afh = [];
		this.attachEvent("onClearAll", function () {
			if (!this.hdr.rows[1]) {
				for (var i = 0; i < this.afh.length; i++) {
					for (var j = 0; j < 4; j++) {
						this.detachEvent(this.afh[i][j]);
					}
				}
				this.afh = [];
			}
		});
	}
	this.afh.push([this.attachEvent("onGridReconstructed", f), this.attachEvent("onXLE", f), this.attachEvent("onFilterEnd", f), this.attachEvent("onEditCell", function (stage, id, ind) {
		if (stage == 2 && (ind == i || (i && i[ind]))) {
			f.call(this);
		}
		return true;
	})]);
	t.innerHTML = "";
};

