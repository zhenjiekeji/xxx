
dhtmlXGridObject.prototype.enableSmartRendering = function (mode, buffer, reserved) {
	if (arguments.length > 2) {
		if (buffer && !this.aD[buffer - 1]) {
			this.aD[buffer - 1] = 0;
		}
		buffer = reserved;
	}
	this.ahK = ap(mode);
	this.ig = this.ig || 20;
	this.Cr = buffer || 0;
};
dhtmlXGridObject.prototype.enablePreRendering = function (buffer) {
	this._srnd_pr = parseInt(buffer || 50);
};
dhtmlXGridObject.prototype.forceFullLoading = function (buffer) {
	buffer = buffer || 50;
	for (var i = 0; i < this.aD.length; i++) {
		if (!this.aD[i]) {
			if (this.callEvent("onDynXLS", [i, buffer])) {
				var self = this;
				this.load(this.tR + jv(this.tR) + "posStart=" + i + "&count=" + buffer, function () {
					window.setTimeout(function () {
						self.forceFullLoading(buffer);
					}, 100);
				}, this._data_type);
			}
			return;
		}
	}
};
dhtmlXGridObject.prototype.acv = function (height) {
	this.ig = parseInt(height);
};
dhtmlXGridObject.prototype._get_view_size = function () {
	return Math.floor(parseInt(this.aL.offsetHeight) / this.ig) + 2;
};
dhtmlXGridObject.prototype._add_filler = function (pos, len, fil) {
	if (!len) {
		return null;
	}
	var id = "__filler__";
	var row = this.uO(id);
	row.firstChild.style.width = "1px";
	for (var i = 1; i < row.childNodes.length; i++) {
		row.childNodes[i].style.display = "none";
	}
	row.firstChild.style.height = len * this.ig + "px";
	fil = fil || this.am[pos];
	if (fil && fil.nextSibling) {
		fil.parentNode.insertBefore(row, fil.nextSibling);
	} else {
		if (cn) {
			this.obj.appendChild(row);
		} else {
			this.obj.rows[0].parentNode.appendChild(row);
		}
	}
	return [pos, len, row];
};
dhtmlXGridObject.prototype._update_srnd_view = function () {
	var min = Math.floor(this.HF.scrollTop / this.ig);
	var max = min + this._get_view_size();
	if (this.hu) {
		var pxHeight = this.HF.scrollTop;
		min = 0;
		while (pxHeight > 0) {
			pxHeight -= this.am[min] ? this.am[min].offsetHeight : this.ig;
			min++;
		}
		max = min + this._get_view_size();
		if (min > 0) {
			min--;
		}
	}
	max += (this._srnd_pr || 0);
	if (max > this.aD.length) {
		max = this.aD.length;
	}
	for (var j = min; j < max; j++) {
		if (!this.am[j]) {
			var res = this._add_from_buffer(j);
			if (res == -1) {
				if (this.tR) {
					this._current_load = [j, (this.Cr ? this.Cr : (max - j))];
					if (this.callEvent("onDynXLS", [j, this._current_load[1]])) {
						this.load(this.tR + jv(this.tR) + "posStart=" + j + "&count=" + this._current_load[1], this._data_type);
					}
				}
				return;
			} else {
				if (this._tgle) {
					this.nl(this._h2.get[this.aD[j].idd], this.aD[j]);
					this.iY(this._h2.get[this.aD[j].idd], this.aD[j]);
				}
				if (j && j == (this.nh ? this.aC : this)["_r_select"]) {
					this.eQ(j, this.cell ? this.cell._cellIndex : 0, true);
				}
			}
		}
	}
	if (this.aC && !this.nh && this.hu) {
		this.aC.HF.scrollTop = this.HF.scrollTop;
	}
};
dhtmlXGridObject.prototype._add_from_buffer = function (ind) {
	var row = this.render_row(ind);
	if (row == -1) {
		return -1;
	}
	if (row._attrs["selected"] || row._attrs["select"]) {
		this.Th(row, false, true);
		row._attrs["selected"] = row._attrs["select"] = null;
	}
	if (!this.Cw) {
		if (this.hC && ind % 2 == 0) {
			row.className = this.hC + ((row.className.indexOf("rowselected") != -1) ? " rowselected " : " ") + (row.Vn || "");
		} else {
			if (this.iI && ind % 2 == 1) {
				row.className = this.iI + ((row.className.indexOf("rowselected") != -1) ? " rowselected " : " ") + (row.Vn || "");
			}
		}
	} else {
		if (this._h2) {
			var x = this._h2.get[row.idd];
			row.className += " " + ((x.gR % 2) ? (this.iI + " " + this.iI) : (this.hC + " " + this.hC)) + "_" + x.gR + (this.bj[x.id].Vn || "");
		}
	}
	for (var i = 0; i < this._fillers.length; i++) {
		var f = this._fillers[i];
		if (f && f[0] <= ind && (f[0] + f[1]) > ind) {
			var pos = ind - f[0];
			if (pos == 0) {
				this._insert_before(ind, row, f[2]);
				this._update_fillers(i, -1, 1);
			} else {
				if (pos == f[1] - 1) {
					this._insert_after(ind, row, f[2]);
					this._update_fillers(i, -1, 0);
				} else {
					this._fillers.push(this._add_filler(ind + 1, f[1] - pos - 1, f[2], 1));
					this._insert_after(ind, row, f[2]);
					this._update_fillers(i, -f[1] + pos, 0);
				}
			}
			return;
		}
	}
};
dhtmlXGridObject.prototype._update_fillers = function (ind, right, left) {
	var f = this._fillers[ind];
	f[1] = f[1] + right;
	f[0] = f[0] + left;
	if (!f[1]) {
		f[2].parentNode.removeChild(f[2]);
		this._fillers.splice(ind, 1);
	} else {
		f[2].firstChild.style.height = parseFloat(f[2].firstChild.style.height) + right * this.ig + "px";
	}
};
dhtmlXGridObject.prototype._insert_before = function (ind, row, fil) {
	fil.parentNode.insertBefore(row, fil);
	this.am[ind] = row;
};
dhtmlXGridObject.prototype._insert_after = function (ind, row, fil) {
	if (fil.nextSibling) {
		fil.parentNode.insertBefore(row, fil.nextSibling);
	} else {
		fil.parentNode.appendChild(row);
	}
	this.am[ind] = row;
};

