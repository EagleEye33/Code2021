def unique3(S, start, stop):
  """Return True if there are no duplicate elements in slice S[start:stop]."""
  if stop - start <= 1: return True                # at most one item
  elif not unique3(S, start, stop-1): return False  # first part has duplicate
  elif not unique3(S, start+1, stop): return False  # second part has duplicate
  else: return S[start] != S[stop-1]               # do first and last differ?


print(unique3([1, 2, 3, 4,], 1, 4))