class UnionFind {
  id = [];
  size = [];

  constructor(n) {
    for (let i = 0; i < n; i++) {
      this.id[i] = i;
      this.size[i] = 1;
    }
  }

  root(i) {
    let r = i;
    while(this.id[r] !== r) {
      r = this.id[r];
    }
    return r;
  }

  union(p, q) {
    let rp = this.root(p);
    let rq = this.root(q);
    if (rp === rq) return;
    if (this.size[rp] > this.size[rq]) {
      this.id[q] = rp;
      this.size[p] += this.size[q];
    } else {
      this.id[p] = rq;
      this.size[q] += this.size[p];
    }
  }

  isConnected(p, q) {
    return this.root(p) === this.root(q);
  }
}