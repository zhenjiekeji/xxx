
dhtmlXGridObject.prototype.Ib = function () {
	if (!this.pj) {
		return;
	}
	this.WJ = false;
	delete this.pj;
	delete this.tH;
	if (this.aC) {
		this._mirror_rowsCol();
	}
	this.forEachRow(function (id) {
		this.bj[id].style.display = "";
	});
	this._reset_view();
	this.callEvent("onGridReconstructed", []);
	this.callEvent("onUnGroup", []);
};
dhtmlXGridObject.prototype._mirror_rowsCol = function () {
	this.aC.pj = this.pj;
	this.aC.tH = this.tH;
	this.aD = dhtmlxArray();
	for (var i = 0; i < this.am.length; i++) {
		if (!this.am[i].te) {
			this.aD.push(this.am[i]);
		}
	}
	this.aC.aD = dhtmlxArray();
	for (var i = 0; i < this.aC.am.length; i++) {
		if (!this.aC.am[i].te) {
			this.aC.aD.push(this.aC.am[i]);
		}
	}
};
dhtmlXGridObject.prototype.OI = function (ind, mask) {
	if (this.pj) {
		this.Ib();
	}
	this.WJ = true;
	this.pj = {};
	if (!mask) {
		mask = ["#title"];
		for (var i = 1; i < this.gA; i++) {
			mask.push("#cspan");
		}
	}
	this._gmask = document.createElement("TR");
	this._gmask.origin = mask;
	var ltd, rindex = 0;
	for (var i = 0; i < mask.length; i++) {
		if (mask[i] == "#cspan") {
			ltd.colSpan = (parseInt(ltd.colSpan) || 1) + 1;
		} else {
			ltd = document.createElement("TD");
			ltd._cellIndex = i;
			if (this._hrrar[i]) {
				ltd.style.display = "none";
			}
			ltd.className = "group_row";
			ltd.innerHTML = "&nbsp;";
			if (mask[i] == "#title") {
				this._gmask.ahi = rindex;
			} else {
				ltd.align = this.cellAlign[i] || "left";
			}
			this._gmask.appendChild(ltd);
			if (mask[i].indexOf("#stat") == 0) {
				this._gmask._math = true;
				ltd._counter = [this["_g_" + mask[i].replace("#", "")], i, rindex];
			}
			rindex++;
		}
	}
	for (var a in this.pj) {
		this.pj[a] = this.undefined;
	}
	this.tH = ind;
	if (this.aC && !this.nh) {
		this.aC.pj = [];
		this.aC.tH = this.tH;
	}
	this.CE = function (ind, dir) {
		var r = this.am[ind + dir];
		if (r && (r.style.display == "none" || r.te)) {
			return this.CE(ind + dir, dir);
		}
		return r;
	};
	if (!this.vE) {
		this.zf = dhtmlXHeir({}, this.zf);
		this.zf.k38_0_0 = function () {
			if (this.editor && this.editor.combo) {
				this.editor.Kc();
			} else {
				var uH = this.row.rowIndex;
				if (!uH) {
					return;
				}
				var NH = this.CE(uH - 1, -1);
				if (NH) {
					this.eQ(NH, this.cell._cellIndex, true);
				}
			}
		};
		this.zf.k13_1_0 = this.zf.k13_0_1 = function () {
		};
		this.zf.k40_0_0 = function () {
			if (this.editor && this.editor.combo) {
				this.editor.eW();
			} else {
				var uH = this.row.rowIndex;
				if (!uH) {
					return;
				}
				var NH = this.CE(uH - 1, 1);
				if (NH) {
					this.eQ(NH, this.cell._cellIndex, true);
				}
			}
		};
		this.attachEvent("onFilterStart", function () {
			if (this.pj) {
				this.pj = this.undefined;
			}
			return true;
		});
		this.attachEvent("onFilterEnd", function () {
			if (typeof this.tH != "undefined") {
				this.OI(this.tH, this._gmask.origin);
			}
		});
		this.sortRows_bg = this.xK;
		this.xK = function (ind, type, dir) {
			if (typeof (this.pj) == "undefined") {
				return this.sortRows_bg.apply(this, arguments);
			}
			this.callEvent("onBeforeSorting", [ind, (type || "str"), (dir || "asc")]);
		};
		this.attachEvent("onBeforeSorting", function (ind, type, dir) {
			if (typeof (this.pj) == "undefined") {
				return true;
			}
			if (ind == this.tH) {
				this.Er(ind, type, dir);
			} else {
				this.EZ(ind, type, dir);
			}
			this.co(true, ind, dir);
			if (this.aC) {
				this._mirror_rowsCol();
				this.aC.pj = [];
				this.aC._reset_view();
			}
			this.co(true, ind, dir);
			this.callEvent("onAfterSorting", [ind, type, dir]);
			return false;
		});
		this.attachEvent("onClearAll", function () {
			this.Ib();
		});
		this.attachEvent("onBeforeRowDeleted", function (id) {
			if (!this.pj) {
				return true;
			}
			if (!this.bj[id]) {
				return true;
			}
			var val = this.cells(id, this.tH).getValue();
			if (val === "") {
				val = " ";
			}
			var z = this.pj[val];
			this.Cc(z);
			return true;
		});
		this.attachEvent("onAfterRowDeleted", function (id) {
			this.updateGroups();
		});
		this.attachEvent("onCheckbox", function (id, index, value) {
			this.callEvent("onEditCell", [2, id, index, (value ? 1 : 0), (value ? 0 : 1)]);
		});
		this.attachEvent("onXLE", this.updateGroups);
		this.attachEvent("onColumnHidden", this.hideGroupColumn);
		this.attachEvent("onEditCell", function (stage, id, ind, val, Kr) {
			if (!this.pj) {
				return true;
			}
			if (stage == 2 && val != Kr && ind == this.tH) {
				if (Kr === "") {
					Kr = " ";
				}
				this.Cc(this.pj[Kr]);
				var r = this.bj[id];
				var i = this.am.bP(r);
				var ni = this.Bp(val);
				var n = this.am[ni];
				if (r == n) {
					n = n.nextSibling;
				}
				var p = r.parentNode;
				var o = r.rowIndex;
				p.removeChild(r);
				if (n) {
					p.insertBefore(r, n);
				} else {
					p.appendChild(r);
				}
				this.am.ml(ni, r);
				if (ni < i) {
					i++;
				}
				this.am.hd(i, r);
				this._fixAlterCss();
			} else {
				if (stage == 2 && val != Kr) {
					this.updateGroups();
					this.qP(this.pj[this.cells(id, this.tH).getValue() || " "]);
				}
			}
			return true;
		});
		this.vE = true;
	}
	this.Cu();
	if (this._hrrar) {
		for (var i = 0; i < this._hrrar.length; i++) {
			if (this._hrrar[i]) {
				this.hideGroupColumn(i, true);
			}
		}
	}
	this.callEvent("onGroup", []);
	if (this.abK || this.Gd) {
		this.setSizes();
	}
};
dhtmlXGridObject.prototype.EZ = function (col, type, order) {
	var b = this.xe();
	b.reverse();
	for (var i = 0; i < b.length; i++) {
		var c = b[i].te.qA;
		var a = {};
		for (var j = 0; j < c.length; j++) {
			var cell = this.cells3(c[j], col);
			a[c[j].idd] = cell.getDate ? cell.getDate() : cell.getValue();
		}
		this.aeo(col, type, order, a, c);
	}
	this.wY(b);
	this.setSizes();
	this.callEvent("onGridReconstructed", []);
};
dhtmlXGridObject.prototype.Er = function (col, type, order) {
	var b = this.xe();
	var a = [];
	for (var i = 0; i < b.length; i++) {
		b[i].idd = "_sort_" + i;
		a["_sort_" + i] = b[i].te.text;
	}
	this.aeo(col, type, order, a, b);
	this.wY(b);
	this.callEvent("onGridReconstructed", []);
	this.setSizes();
};
dhtmlXGridObject.prototype.Bp = function (val, hidden, Ch) {
	if (val === "") {
		val = " ";
	}
	if (!this.pj[val]) {
		this.pj[val] = {text:val, row:this.xW(), count:0, state:hidden ? "plus" : "minus"};
	}
	var z = this.pj[val];
	z.row.te = z;
	var ind = this.am.bP(z.row) + z.count + 1;
	z.count++;
	if (!Ch) {
		this.qP(z);
		this.updateGroups();
	}
	return ind;
};
dhtmlXGridObject.prototype.Cc = function (z) {
	if (!z) {
		return;
	}
	z.count--;
	if (z.count == 0) {
		z.row.parentNode.removeChild(z.row);
		this.am.hd(this.am.bP(z.row));
		delete this.pj[z.text];
	} else {
		this.qP(z);
	}
	if (this.aC && !this.nh) {
		this.aC.Cc(this.aC.pj[z.text]);
	}
	this.updateGroups();
	return true;
};
dhtmlXGridObject.prototype.BB = dhtmlXGridObject.prototype._insertRowAt;
dhtmlXGridObject.prototype._insertRowAt = function (r, ind, Ch) {
	if (typeof (this.pj) != "undefined") {
		if (this.nh) {
			var val = this.aC._bfs_cells(r.idd, this.tH).getValue();
		} else {
			if (this.Hg) {
				var val = this.Hg(r, this.tH).getValue();
			} else {
				var val = this.cells3(r, this.tH).getValue();
			}
		}
		if (!val) {
			val = " ";
		}
		ind = this.Bp(val, r.style.display == "none");
	}
	var res = this.BB(r, ind, Ch);
	if (typeof (this.pj) != "undefined") {
		this.Oc(val);
		this.qP(this.pj[val]);
		this.updateGroups();
	}
	return res;
};
dhtmlXGridObject.prototype.qP = function (z) {
	if (this.aC && !this.nh) {
		return z.row.firstChild.innerHTML = "&nbsp;";
	}
	var mask = this._gmask || this.aC._gmask;
	var html = "<img style='margin-bottom:-4px' src='" + this.eg + z.state + ".gif'> ";
	if (this.yW) {
		html += this.yW(z.text, z.count);
	} else {
		html += z.text + " ( " + z.count + " ) ";
	}
	z.row.childNodes[mask.ahi].innerHTML = html;
};
dhtmlXGridObject.prototype.xW = function (Ch) {
	var mask = this._gmask || this.aC._gmask;
	var r = mask.cloneNode(true);
	for (var i = 0; i < r.childNodes.length; i++) {
		r.childNodes[i]._cellIndex = mask.childNodes[i]._cellIndex;
		if (this.nh) {
			r.childNodes[i].style.display = "";
		}
	}
	var that = this;
	r.onclick = function (e) {
		if (that.aC && that.nh) {
			that.aC.qk(that.aC.pj[this.te.text].row);
		} else {
			that.qk(this);
		}
		(e || event).cancelBubble = "true";
	};
	r.ondblclick = function (e) {
		(e || event).cancelBubble = "true";
	};
	if (!Ch) {
		if (cn) {
			this.obj.appendChild(r);
		} else {
			this.obj.firstChild.appendChild(r);
		}
		this.am.push(r);
	}
	return r;
};
dhtmlXGridObject.prototype.xe = function () {
	var b = [];
	this.uw = this.obj.parentNode;
	this.uw.removeChild(this.obj);
	var a = [];
	for (var i = this.am.length - 1; i >= 0; i--) {
		if (this.am[i].te) {
			this.am[i].te.qA = a;
			a = [];
			b.push(this.am[i]);
		} else {
			a.push(this.am[i]);
		}
		this.am[i].parentNode.removeChild(this.am[i]);
	}
	return b;
};
dhtmlXGridObject.prototype.wY = function (b) {
	this.am = new dhtmlxArray(0);
	for (var i = 0; i < b.length; i++) {
		var gr = b[i].te;
		this.obj.firstChild.appendChild(gr.row);
		this.am.push(gr.row);
		gr.row.idd = null;
		for (var j = 0; j < gr.qA.length; j++) {
			this.obj.firstChild.appendChild(gr.qA[j]);
			this.am.push(gr.qA[j]);
		}
		delete gr.qA;
	}
	this.uw.appendChild(this.obj);
};
dhtmlXGridObject.prototype.Cu = function (b) {
	if (!this.iD()) {
		return;
	}
	var b = [];
	this.uw = this.obj.parentNode;
	this.uw.removeChild(this.obj);
	var a = [];
	var mlen = this.am.length;
	for (var i = 0; i < mlen; i++) {
		var val = this.cells4(this.am[i].childNodes[this.tH]).getValue();
		this.am[i].style.display = "";
		if (!val) {
			val = " ";
		}
		if (!this.pj[val]) {
			this.pj[val] = {text:val, row:this.xW(true), count:0, state:"minus"};
			var z = this.pj[val];
			z.row.te = z;
			this.pj[val].qA = [];
			b.push(z.row);
		}
		this.pj[val].count++;
		this.pj[val].qA.push(this.am[i]);
		this.am[i].parentNode.removeChild(this.am[i]);
	}
	for (var i = 0; i < b.length; i++) {
		this.qP(b[i].te);
	}
	this.wY(b);
	if (this.aC && !this.nh) {
		this._mirror_rowsCol();
		this.aC.pj = [];
		this.aC._reset_view();
	}
	this.callEvent("onGridReconstructed", []);
	this.updateGroups();
};
dhtmlXGridObject.prototype.qk = function (row) {
	var z = row.te;
	if (this.aC && !this.nh) {
		z.state = this.aC.pj[row.te.text].row.te.state;
		this.aC.qk(this.aC.pj[row.te.text].row);
	}
	var ind = this.am.bP(z.row) + 1;
	z.state = z.state == "minus" ? "plus" : "minus";
	var st = z.state == "plus" ? "none" : "";
	while (this.am[ind] && !this.am[ind].te) {
		this.am[ind].style.display = st;
		ind++;
	}
	this.qP(z);
	this.callEvent("onGroupStateChanged", [z.text, (z.state == "minus")]);
	this.setSizes();
};
dhtmlXGridObject.prototype.Oc = function (val) {
	if (this.pj[val].state == "plus") {
		this.qk(this.pj[val].row);
	}
};
dhtmlXGridObject.prototype.Nu = function (val) {
	if (this.pj[val].state == "minus") {
		this.qk(this.pj[val].row);
	}
};
dhtmlXGridObject.prototype.Mg = function () {
	for (var i in this.pj) {
		if (this.pj[i] && this.pj[i].state == "plus") {
			this.qk(this.pj[i].row);
		}
	}
};
dhtmlXGridObject.prototype.KU = function () {
	for (var i in this.pj) {
		if (this.pj[i] && this.pj[i].state == "minus") {
			this.qk(this.pj[i].row);
		}
	}
};
dhtmlXGridObject.prototype.hideGroupColumn = function (ind, state) {
	if (this.aC) {
		return;
	}
	var rind = -1;
	var row = this._gmask.childNodes;
	for (var i = 0; i < row.length; i++) {
		if (row[i]._cellIndex == ind) {
			rind = i;
			break;
		}
	}
	if (rind == -1) {
		return;
	}
	for (var a in this.pj) {
		this.pj[a].row.childNodes[rind].style.display = state ? "none" : "";
	}
};
dhtmlXGridObject.prototype.groupStat = function (name, ind, math) {
	math = this["_g_" + (math || "stat_total")];
	var AG = 0;
	var index = 0;
	this.forEachRowInGroup(name, function (id) {
		AG = math(AG, this.cells(id, ind).getValue() * 1, index);
		index++;
	});
	return AG;
};
dhtmlXGridObject.prototype.forEachRowInGroup = function (name, code) {
	var row = this.pj[name].row.nextSibling;
	if (row) {
		while (row && !row.te) {
			code.call(this, row.idd);
			row = row.nextSibling;
		}
	} else {
		var cs = this.pj[name].qA;
		if (cs) {
			for (var i = 0; i < cs.length; i++) {
				code.call(this, cs[i].idd);
			}
		}
	}
};
dhtmlXGridObject.prototype.updateGroups = function () {
	if (!this._gmask || !this._gmask._math || this._parsing) {
		return;
	}
	var r = this._gmask.childNodes;
	for (var i = 0; i < r.length; i++) {
		if (r[i]._counter) {
			this._b_processing.apply(this, r[i]._counter);
		}
	}
};
dhtmlXGridObject.prototype._b_processing = function (a, ind, rind) {
	var c = 0, j = 0;
	if (!this.XC[this.cellType[ind]]) {
		this.adH({parentNode:{grid:this}}, this.cellType[ind]);
	}
	for (var i = this.am.length - 1; i >= 0; i--) {
		if (!this.am[i].te) {
			c = a(c, this.cells3(this.am[i], ind).getValue() * 1, j);
			j++;
		} else {
			this.adH(this.am[i].childNodes[rind], this.cellType[ind]).setValue(c);
			j = c = 0;
		}
	}
};
dhtmlXGridObject.prototype._g_stat_total = function (c, n, i) {
	return c + n;
};
dhtmlXGridObject.prototype._g_stat_min = function (c, n, i) {
	if (!i) {
		c = Infinity;
	}
	return Math.min(c, n);
};
dhtmlXGridObject.prototype._g_stat_max = function (c, n, i) {
	if (!i) {
		c = -Infinity;
	}
	return Math.max(c, n);
};
dhtmlXGridObject.prototype._g_stat_average = function (c, n, i) {
	return (c * i + n) / (i + 1);
};
dhtmlXGridObject.prototype._g_stat_count = function (c, n, i) {
	return c++;
};

