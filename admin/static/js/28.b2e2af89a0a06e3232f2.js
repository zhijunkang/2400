webpackJsonp([28], {
	"3bH0": function(t, s, i) {
		"use strict";
		Object.defineProperty(s, "__esModule", {
			value: !0
		});
		var a = {
			render: function() {
				var t = this.$createElement,
					s = this._self._c || t;
				return s("div", {
					staticClass: "wrapper"
				}, [s("div", {
					staticClass: "main"
				}, [this._m(0), this._v(" "), s("div", {
					staticClass: "main-btn-group"
				}, [s("el-row", [s("el-button", {
					staticClass: "pull-left",
					attrs: {
						type: "danger"
					},
					on: {
						click: this.goBack
					}
				}, [this._v("上一页")]), this._v(" "), s("router-link", {
					attrs: {
						to: "/"
					}
				}, [s("el-button", {
					staticClass: "pull-right",
					attrs: {
						type: "info"
					}
				}, [this._v("首页")])], 1)], 1)], 1)])])
			},
			staticRenderFns: [function() {
				var t = this.$createElement,
					s = this._self._c || t;
				return s("div", {
					staticClass: "main-info"
				}, [s("span", {
					staticClass: "main-info--emphasis"
				}, [this._v("4")]), this._v(" "), s("span", {
					staticClass: "main-info--normal"
				}, [this._v("0")]), this._v(" "), s("span", {
					staticClass: "main-info--emphasis"
				}, [this._v("4")])])
			}]
		};
		var n = i("VU/8")({
			name: "404",
			methods: {
				goBack: function() {
					this.$router.go(-1)
				}
			}
		}, a, !1, function(t) {
			i("Imrg")
		}, "data-v-02592410", null);
		s.default = n.exports
	},
	Imrg: function(t, s) {}
});
//# sourceMappingURL=28.b2e2af89a0a06e3232f2.js.map
